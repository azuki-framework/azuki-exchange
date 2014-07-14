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
import java.util.List;
import java.util.Map;

import org.azkfw.exchange.exchange.CsvExchange.CsvInputPart;
import org.azkfw.exchange.exchange.CsvExchange.CsvOutputPart;
import org.azkfw.exchange.part.input.AbstractInputPart;
import org.azkfw.exchange.part.input.InputResult;
import org.azkfw.exchange.part.output.AbstractOutputPart;
import org.azkfw.exchange.part.output.OutputResult;
import org.azkfw.io.CsvBufferedReader;
import org.azkfw.io.CsvBufferedWriter;

/**
 * このクラスは、CSV用のエクスチェンジクラスです。
 * 
 * @since 1.0.0
 * @version 1.0.0 2014/07/14
 * @author Kawakicchi
 */
public class CsvExchange extends AbstractExchange<CsvInputPart, CsvOutputPart> {

	public CsvExchange() {

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
	public CsvInputPart generateInputPart() {
		CsvInputPart input = new CsvInputPart();
		return input;
	}

	@Override
	public CsvOutputPart generateOutputPart() {
		CsvOutputPart output = new CsvOutputPart();
		return output;
	}

	public final class CsvInputPart extends AbstractInputPart {

		private CsvBufferedReader reader;

		private CsvInputPart() {

		}

		@Override
		public void doInitialize() {
		}

		@Override
		public void doRelease() {

		}

		@Override
		public void doOpen() throws IOException {
			reader = new CsvBufferedReader("test1.csv");
		}

		@Override
		public void doClose() throws IOException {
			if (null != reader) {
				try {
					reader.close();
				} catch (IOException ex) {

				} finally {
					reader = null;
				}
			}
		}

		@Override
		protected InputResult doRead(final Map<String, Object> aMap) throws IOException {
			List<String> line = reader.readCsvLine();
			if (null != line) {

				return InputResult.Continue;
			} else {
				return InputResult.End;
			}
		}

	}

	public final class CsvOutputPart extends AbstractOutputPart {

		private CsvBufferedWriter writer;

		private CsvOutputPart() {

		}

		@Override
		public void doInitialize() {

		}

		@Override
		public void doRelease() {

		}

		@Override
		public void doOpen() throws IOException {
			writer = new CsvBufferedWriter("test2.csv");
		}

		@Override
		public void doClose() {
			if (null != writer) {
				try {
					writer.close();
				} catch (IOException ex) {

				} finally {
					writer = null;
				}
			}
		}

		@Override
		public OutputResult doWrite(final Map<String, Object> aMap) {

			return OutputResult.Success;
		}

	}
}
