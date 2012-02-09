package net.vidageek.games.regex.task;

import static net.vidageek.games.regex.task.MatcherTargets.fromStrings;

import java.util.List;

import net.vidageek.games.Game;
import net.vidageek.games.task.CharClassRegex;
import net.vidageek.games.task.TaskWithDescription;

final public class RegexGame implements Game {

	private final Tasks tasks;

	public RegexGame() {
		tasks = new Tasks();
		addExercises1();
		addExercises2();
		addExercises3();
		addExercises4();
		addExercises5();
	}

	private void addExercises1() {
		TaskGroup group = new TaskGroup();
		group.add(new PerfectMatchRegex("a"));
		group.add(new PerfectMatchRegex("b"));
		group.add(new PerfectMatchRegex("ab"));
		group.add(new PerfectMatchRegex("abc"));
		group.add(new PerfectMatchRegex("\\"));
		group.add(new PerfectMatchRegex("$"));
		group.add(new PerfectMatchRegex("abcdefg"));
		group.add(new PerfectMatchRegex("ab$cd^ef\\g"));
		tasks.add(group);
	}

	private void addExercises2() {
		TaskGroup group = new TaskGroup();
		group.add(new CharClassRegex(fromStrings("a", "b")));
		group.add(new CharClassRegex(fromStrings("ad", "bd")));
		group.add(new CharClassRegex(fromStrings("ad", "bd", "cd")));
		group.add(new CharClassRegex(fromStrings("a", "b", "c")));
		group.add(new CharClassRegex(fromStrings("a", "b", "c", "A", "B", "C", "D")));
		group.add(new CharClassRegex(fromStrings("0", "1", "2")));
		group.add(new CharClassRegex(fromStrings("1", "4", "5")));
		group.add(new CharClassRegex(fromStrings("1a", "4a", "5a")));
		group.add(new CharClassRegex(fromStrings("1", "4", "5", "a")));
		group.add(new CharClassRegex(fromStrings(" ", "\t", "\n", "\f", "\r")));
		group.add(new CharClassRegex(fromStrings(" a", "\ta", "\na")));
		group.add(new CharClassRegex(fromStrings(" ", "\t", "\n", "a")));
		group.add(new CharClassRegex(fromStrings("a", "b", "9")));
		group.add(new CharClassRegex(fromStrings("ap", "bp", "9p")));
		group.add(new CharClassRegex(fromStrings("a", "B", "9", "$", "\t", " ")));
		tasks.add(group);
	}

	private void addExercises3() {
		TaskGroup group = new TaskGroup();
		group.add(new NegateCharClassRegex(fromStrings("a", "b"), fromStrings("c", "d")));
		group.add(new NegateCharClassRegex(fromStrings("ad", "bd"), fromStrings("cd", "dd")));
		group.add(new NegateCharClassRegex(fromStrings("ad", "bd", "cd"), fromStrings("dd", "ed")));
		group.add(new NegateCharClassRegex(fromStrings("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"),
				fromStrings(" ", "a")));
		group.add(new NegateCharClassRegex(fromStrings("1a", "4a", "5a"), fromStrings(" a", "$a")));
		group.add(new NegateCharClassRegex(fromStrings("1", "4", "5", "a"), fromStrings(" ", "b")));
		group.add(new NegateCharClassRegex(fromStrings("\t", "\n", "\f", "\r"), fromStrings("A", "w")));
		group.add(new NegateCharClassRegex(fromStrings(" a", "\ta", "\na"), fromStrings("ca", "#a")));
		group.add(new NegateCharClassRegex(fromStrings(" ", "\t", "\n", "a"), fromStrings("Z", "A")));
		group.add(new NegateCharClassRegex(fromStrings("a", "B", "9"), fromStrings(" ", "$")));
		group.add(new NegateCharClassRegex(fromStrings("ap", "Bp", "9p"), fromStrings("$p", "#p")));
		tasks.add(group);
	}

	private void addExercises4() {
		TaskGroup group = new TaskGroup();
		group.add(new OperatorMatcher("a"));
		tasks.add(group);
	}

	private void addExercises5() {
		TaskGroup group = new TaskGroup();
		group.add(new CaptureGroup("abcdef", "abcdef"));
		group.add(new CaptureGroup("abcdef1a", "abcdef"));
		group.add(new CaptureGroup("abcdef1a", "abcdef", "1a"));
		group.add(new CaptureGroup("abcdef1a", "abcdef1a", "abcdef", "1"));
		tasks.add(group);
	}

	public TaskWithDescription task(final int index) {

		return tasks.at(index);
	}

	public int size() {
		return tasks.size();
	}

	public String getDescription() {
		return "Um jogo muito legal para aprender RegEx";
	}

	public List<? extends TaskWithDescription> getTasks() {
		return tasks.all();
	}

	public String getName() {
		return "RegEx";
	}

	public boolean hasNextTask(final int index) {
		return nextTask(index) < size();
	}

	public int nextTask(final int index) {
		return index + 1;
	}

}