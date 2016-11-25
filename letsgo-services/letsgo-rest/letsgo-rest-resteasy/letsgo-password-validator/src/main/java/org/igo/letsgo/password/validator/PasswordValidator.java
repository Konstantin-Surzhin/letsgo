/*
 * Copyright (C) 2016 surzhin.konstantin
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.igo.letsgo.password.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Валидатор паролей. <br>
 * Проверки: <br>
 * 1) наличие букв и цифр; <br>
 * 2) наличие букв разных регистров; <br>
 * 3) учет количества одинаковых символов; <br>
 * 4) наличие «отражённых» последовательностей символов; <br>
 * 5) наличие повторных комбинаций последовательностей символов; <br>
 * 6) наличие предопределенных последовательностей символов (например,
 * алфавитный порядок или расположение на клавиатуре). <br>
 * 7) длина пароля - не менее 8 символов. <br>
 * Автор: Большой Синий Кит
 *
 * @author surzhin.konstantin
 */
public class PasswordValidator {

    private static final String SYMBOLS_PATTERN_STR = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,14})"
            + "|((?=.*\\d)(?=.*[а-я])(?=.*[А-Я]).{8,14})";

    private final Pattern SYMBOLS_PATTERN = Pattern.compile(SYMBOLS_PATTERN_STR);

    // private Matcher matcher;
    /**
     * ( # Начало группы (?=.*\d) # должен содержать как минимум одну цифру
     * (?=.*[a-z]) # должен содержать как минимум букву в нижнем регистре
     * (?=.*[A-Z]) # должен содержать как минимум букву в верхнем регистре .
     * любое совпадение с предыдущими условиями {8,14} # длина от 8 до 14
     * символов ) # Конец группы
     * <p/>
     * Аналогичная запись для русского/украинского алфавита
     */
    private static final String REPEATS_PATTERN = "(%s)|(%s)";

    /**
     * Максимальное количество дублирующихся символов
     */
    private static final int MAX_COUNT_DUBLICATED_SYMBOLS = 3;

    /**
     * Длина строки для проверки на предопределенные последовательности
     */
    private static final int MAX_STRING_LENGHT_SEQUENCES = 4;

    /**
     * Длина строки для проверки повтор прямых и отраженных комбинаций
     */
    private static final int MAX_STRING_LENGHT_REPEATS = 2;

    /**
     * Предопределенные последовательности: клавиатуры, алфавиты, цифровые
     * последовательности
     */
    private static final String[] PREDEFINED_SEQUENCES = {
        /**
         * клавиатура ENG
         */
        "qwertyuiopasdfghjklzxcvbnm",
        /**
         * клавиатура RUS
         */
        "йцукенгшщзхъфывапролджэячсмитьбю",
        /**
         * клавиатура UKR
         */
        "йцукенгшщзхїфівапролджєячсмитьбю",
        /**
         * Алфавит ENG
         */
        "abcdefghijklmnopqrstuvwxyz",
        /**
         * Алфавит RUS
         */
        "абвгдеёжзиклмнопрстуфхцчшщьъэюя",
        /**
         * Алфавит UKR
         */
        "абвгдеєжзиіїйклмнопрстуфхцчшщьюя",
        /**
         * Цифры
         */
        "1234567890"
    };

    public boolean validate(final String password) {
        return validateSymbols(password)
                && validateMatches(password)
                && validatePredefinedSequences(password)
                && validateDublicatedSymbols(password);
    }

    /**
     * Проверка пароля на существование в нем определенных символов.
     *
     * @param password пароль для валидации
     * @return true если пароль валидный, false - пароль не валидный
     */
    private boolean validateSymbols(final String password) {
        final Matcher matcher = SYMBOLS_PATTERN.matcher(password);
        return matcher.matches();
    }

    /**
     * Проверка на повтор прямых и отраженных комбинаций
     *
     * @param password пароль
     * @return true если пароль валидный, false - пароль невалидный
     */
    private boolean validateMatches(final String password) {
        int countOfMatches;
        final String passwLower = password.toLowerCase();
        for (int i = 0; i < passwLower.length() / 2; ++i) {
            for (int j = i + MAX_STRING_LENGHT_REPEATS;
                    j < passwLower.length() / 2 + MAX_STRING_LENGHT_REPEATS; ++j) {
                //чтобы не выйти за пределы массива
                if (passwLower.length() < passwLower.length() / 2 + MAX_STRING_LENGHT_REPEATS) {
                    break;
                }
                countOfMatches = 0;
                final String matchWord = passwLower.substring(i, j);
                final String matchWorldReverse = new StringBuffer(matchWord).reverse().toString();
                final Pattern pattern = Pattern.compile(String.format(REPEATS_PATTERN, matchWord, matchWorldReverse));
                final Matcher matcher = pattern.matcher(passwLower);
                while (matcher.find()) {
                    if (++countOfMatches > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Проверка на наличие предопределенных последовательностей символов
     * (алфавитные последовательности, клавиатурные последовательности)
     *
     * @param password
     * @return true если пароль валидный, false - пароль невалидный
     */
    private boolean validatePredefinedSequences(final String password) {
        int coincidences;
        final String passwordLower = password.toLowerCase();

        for (int i = 0; i < PREDEFINED_SEQUENCES.length; ++i) {
            final String currentKeyboard = PREDEFINED_SEQUENCES[i];
            for (int j = 0; j < currentKeyboard.length() - MAX_STRING_LENGHT_SEQUENCES + 1; ++j) {
                coincidences = 0;
                final String matchWord = currentKeyboard.substring(j, j + MAX_STRING_LENGHT_SEQUENCES);
                final String matchWorldReverse = new StringBuffer(matchWord).reverse().toString();
                final Pattern pattern = Pattern.compile(String.format(REPEATS_PATTERN, matchWord, matchWorldReverse));
                final Matcher matcher = pattern.matcher(passwordLower);
                while (matcher.find()) {
                    if (++coincidences > 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Учет количества одинаковых символов
     *
     * @param password
     * @return true если пароль валидный, false - пароль невалидный
     */
    private boolean validateDublicatedSymbols(final String password) {
        final String passwordLower = password.toLowerCase();
        int countOfDublicated;
        char symbol;
        for (int i = 0; i < passwordLower.length(); ++i) {
            countOfDublicated = 0;
            symbol = password.charAt(i);
            for (int j = i; j < passwordLower.length(); ++j) {
                if (passwordLower.charAt(j) == symbol) {
                    if (++countOfDublicated > MAX_COUNT_DUBLICATED_SYMBOLS) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
