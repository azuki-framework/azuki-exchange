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
package org.azkfw.exchange.exchange;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.azkfw.exchange.exchange.MemoryExchange.MemoryInputPart;
import org.azkfw.exchange.exchange.MemoryExchange.MemoryOutputPart;
import org.azkfw.exchange.part.input.AbstractInputPart;
import org.azkfw.exchange.part.input.InputResult;
import org.azkfw.exchange.part.output.AbstractOutputPart;
import org.azkfw.exchange.part.output.OutputResult;

/**
 * このクラスは、メモリ用のエクスチェンジクラスです。
 * 
 * @since 1.0.0
 * @version 1.0.0 2014/07/14
 * @author Kawakicchi
 */
public class MemoryExchange extends AbstractExchange<MemoryInputPart, MemoryOutputPart> {

	public MemoryExchange() {

	}

	@Override
	public boolean isSupportInput() {
		return true;
	}

	@Override
	public boolean isSupportOutput() {
		return true;
	}

	@Override
	public MemoryInputPart generateInputPart() {
		MemoryInputPart input = new MemoryInputPart();
		return input;
	}

	@Override
	public MemoryOutputPart generateOutputPart() {
		MemoryOutputPart output = new MemoryOutputPart();
		return output;
	}

	public final class MemoryInputPart extends AbstractInputPart {

		private List<Map<String, Object>> data;

		private int index;

		private MemoryInputPart() {
			data = new ArrayList<Map<String, Object>>();
		}

		public void add(final Map<String, Object> aMap) {
			data.add(aMap);
		}

		public void addAll(final List<Map<String, Object>> aList) {
			data.addAll(aList);
		}

		@Override
		public void doInitialize() {
		}

		@Override
		public void doRelease() {

		}

		@Override
		public void doOpen() throws IOException {
			index = 0;
		}

		@Override
		public void doClose() throws IOException {
		}

		@Override
		protected InputResult doRead(final Map<String, Object> aMap) throws IOException {
			if (index < data.size()) {
				Map<String, Object> map = data.get(index);

				aMap.clear();
				aMap.putAll(map);

				index++;
				return InputResult.Continue;
			} else {
				return InputResult.End;
			}
		}

	}

	public final class MemoryOutputPart extends AbstractOutputPart {

		private List<Map<String, Object>> data;

		private MemoryOutputPart() {
			data = new ArrayList<Map<String, Object>>();
		}

		public List<Map<String, Object>> getData() {
			return data;
		}

		@Override
		public void doInitialize() {

		}

		@Override
		public void doRelease() {

		}

		@Override
		public void doOpen() throws IOException {
		}

		@Override
		public void doClose() {
		}

		@Override
		public OutputResult doWrite(final Map<String, Object> aMap) {
			Map<String, Object> map = new HashMap<String, Object>(aMap);
			data.add(map);
			return OutputResult.Success;
		}

	}
}
