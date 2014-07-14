/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.azkfw.exchange;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.azkfw.exchange.part.input.InputPart;
import org.azkfw.exchange.part.input.InputResult;
import org.azkfw.exchange.part.mapping.MappingPart;
import org.azkfw.exchange.part.mapping.MappingResult;
import org.azkfw.exchange.part.output.OutputPart;
import org.azkfw.exchange.part.output.OutputResult;

/**
 * このクラスは、エクスチェンジクラスです。
 * 
 * @since 1.0.0
 * @version 1.0.0 2014/07/14
 * @author Kawakicchi
 */
public final class AzukiExchanger {

	public static void main(final String[] args) {

	}

	public void exchange() {
		InputPart input = null;
		OutputPart output = null;
		MappingPart mapping = null;

		try {
			input.initialize();
			output.initialize();
			mapping.initialize();

			input.open();
			output.open();

			while (true) {
				Map<String, Object> inputMap = new HashMap<String, Object>();
				InputResult rstInput = input.read(inputMap);
				if (rstInput.isEnd()) {
					break;
				}
				if (rstInput.isSkip()) {
					continue;
				}

				Map<String, Object> outputMap = new HashMap<String, Object>();
				MappingResult rstMapping = mapping.mapping(inputMap, outputMap);
				if (false == rstMapping.isResult()) {
					break;
				}

				OutputResult rstOutput = output.write(outputMap);
				if (false == rstOutput.isResult()) {
					break;
				}
			}

		} catch (IOException ex) {

		} finally {
			if (null != output) {
				try {
					output.close();
				} catch (IOException ex) {

				}
			}
			if (null != input) {
				try {
					input.close();
				} catch (IOException ex) {

				}
			}

			if (null != mapping) {
				mapping.release();
			}
			if (null != output) {
				output.release();
			}
			if (null != input) {
				input.release();
			}

			mapping = null;
			output = null;
			input = null;
		}

	}

}
