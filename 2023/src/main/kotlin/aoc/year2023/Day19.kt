package aoc.year2023

import aoc.library.Puzzle

object Day19 : Puzzle<Int, Int>(day = 19) {

  override fun solvePart1(input: String): Int {
    val system = System.parse(input)
    return system.parts.sumOf { part ->
      system.process(WorkflowName("in"), part)
    }
  }

  override fun solvePart2(input: String): Int {
    TODO()
  }

  private data class System(
    val workflows: List<Workflow>,
    val parts: List<Parts>,
  ) {

    fun process(
      workflowName: WorkflowName,
      parts: Parts,
    ): Int {
      val workflow = workflows.first { it.name == workflowName }
      return when (val destination = workflow.process(parts)) {
        Destination.Accepted -> parts.parts.values.sum()
        Destination.Rejected -> 0
        is Destination.ToWorkflow -> {
          process(destination.workflow, parts)
        }
      }
    }

    companion object {
      fun parse(input: String): System {
        val (workflowValue, partsValue) = input.split("\n\n")
        return System(
          workflows = workflowValue.lines().map(Workflow::parse),
          parts = partsValue.lines().map(Parts::parse),
        )
      }
    }
  }

  private data class Parts(
    val parts: Map<PartId, Int>,
  ) {

    operator fun get(partId: PartId) = parts.getValue(partId)

    companion object {
      fun parse(input: String): Parts {
        val parts = input.removeSurrounding("{", "}")
          .split(",")
          .associate {
            val (id, value) = it.split("=")
            PartId(id) to value.toInt()
          }
        return Parts(parts)
      }
    }
  }

  @JvmInline
  private value class WorkflowName(val name: String)

  @JvmInline
  private value class PartId(val id: String)

  private data class Workflow(
    val name: WorkflowName,
    val rules: List<Rule>,
  ) {

    fun process(parts: Parts): Destination {
      val rule = rules.first { rule ->
        rule.evaluate(parts)
      }
      return rule.destination
    }

    companion object {
      fun parse(input: String): Workflow {
        val name = input.substringBefore('{')
        val rules = input.substringAfter('{').substringBefore('}')
          .split(",")
          .map(Rule::parse)
        return Workflow(WorkflowName(name), rules)
      }
    }
  }

  private data class Rule(val condition: Condition, val destination: Destination) {

    fun evaluate(parts: Parts): Boolean {
      return when (condition) {
        Condition.AlwaysTrue -> true
        is Condition.GreaterThan -> {
          parts[condition.partId] > condition.value
        }
        is Condition.LessThan -> {
          parts[condition.partId] < condition.value
        }
      }
    }

    companion object {
      fun parse(input: String): Rule {
        return if (input.contains(":")) {
          val (conditionValue, destination) = input.split(":")
          val condition = Condition.parse(conditionValue)
          Rule(condition, Destination.parse(destination))
        } else {
          Rule(
            condition = Condition.AlwaysTrue,
            destination = Destination.parse(input),
          )
        }
      }
    }
  }

  private sealed interface Destination {
    data object Accepted : Destination
    data object Rejected : Destination
    data class ToWorkflow(val workflow: WorkflowName) : Destination

    companion object {
      fun parse(input: String): Destination {
        return when (input) {
          "A" -> Accepted
          "R" -> Rejected
          else -> ToWorkflow(WorkflowName(input))
        }
      }
    }
  }

  private sealed interface Condition {
    data class GreaterThan(val partId: PartId, val value: Int) : Condition
    data class LessThan(val partId: PartId, val value: Int) : Condition
    data object AlwaysTrue : Condition

    companion object {
      fun parse(input: String): Condition {
        val (partId, value) = input.split('<', '>')
        return if ("<" in input) {
          LessThan(PartId(partId), value.toInt())
        } else {
          GreaterThan(PartId(partId), value.toInt())
        }
      }
    }
  }
}
