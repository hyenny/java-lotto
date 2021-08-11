package calculator.utils;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import calculator.model.Character;

public class RegexComposer {

	private static final String PATTERN_REG_EXP = "^//(.)\n(.*)$";
	private static final String DEFAULT_REG_EXP = "[,:]";
	private static final Pattern pattern = Pattern.compile(PATTERN_REG_EXP);

	private RegexComposer() {

	}

	public static List<Character> createCharacters(String calculatorValue) {
		Validation.validStringEmptyCheck(calculatorValue);
		Matcher matcher = pattern.matcher(calculatorValue);
		if (matcher.find()) {
			return Arrays.stream(matcher.group(2).split(matcher.group(1)))
				.map(text -> new Character(toInt(text)))
				.collect(Collectors.toList());
		}
		return Arrays.stream(calculatorValue.split(DEFAULT_REG_EXP))
			.map(text -> new Character(toInt(text)))
			.collect(Collectors.toList());
	}

	private static int toInt(String character) {
		Validation.validNumberTypeCheck(character);
		return Integer.parseInt(character);
	}
}