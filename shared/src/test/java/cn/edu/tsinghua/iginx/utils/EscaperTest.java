/*
 * IGinX - the polystore system with high performance
 * Copyright (C) Tsinghua University
 * TSIGinX@gmail.com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package cn.edu.tsinghua.iginx.utils;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class EscaperTest {

  @Test
  public void escape() {
    Map<Character, Character> replacementMap = new HashMap<>();
    replacementMap.put('\\', '\\');
    replacementMap.put('$', '!');
    Escaper escaper = new Escaper('\\', replacementMap);

    assertEquals("hello\\!world", escaper.escape("hello$world"));
    assertEquals("hello\\\\world", escaper.escape("hello\\world"));
  }

  @Test
  public void unescape() throws ParseException {
    Map<Character, Character> replacementMap = new HashMap<>();
    replacementMap.put('\\', '\\');
    replacementMap.put('$', '!');
    Escaper escaper = new Escaper('\\', replacementMap);

    assertEquals("hello$world", escaper.unescape("hello\\!world"));
    assertEquals("hello\\world", escaper.unescape("hello\\\\world"));
  }
}