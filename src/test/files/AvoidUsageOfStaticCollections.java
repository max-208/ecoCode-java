/*
 * creedengo - Java language - Provides rules to reduce the environmental footprint of your Java programs
 * Copyright © 2024 Green Code Initiative (https://green-code-initiative.org/)
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
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.greencodeinitiative.creedengo.java.checks;

import java.util.*;

/**
 * Not compliant
 */
public class AvoidUsageOfStaticCollections {

    public static final List<String> LIST = new ArrayList<String>(); // Noncompliant {{Avoid usage of static collections.}}

    public static final Set<String> SET = new HashSet<String>(); // Noncompliant {{Avoid usage of static collections.}}

    public static final Map<String, String> MAP = new HashMap<String, String>(); // Noncompliant {{Avoid usage of static collections.}}

    public AvoidUsageOfStaticCollections() {
    }

}
