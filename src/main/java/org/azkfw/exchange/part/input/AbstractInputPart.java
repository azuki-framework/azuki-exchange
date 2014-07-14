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
package org.azkfw.exchange.part.input;

import java.io.IOException;
import java.util.Map;

import org.azkfw.exchange.part.AbstractExchangePart;

/**
 * @since 1.0.0
 * @version 1.0.0 2014/07/14
 * @author Kawakicchi
 */
public abstract class AbstractInputPart extends AbstractExchangePart implements InputPart {

	@Override
	public final void open() throws IOException {
		doOpen();
	}

	@Override
	public final void close() throws IOException {
		doClose();
	}

	@Override
	public final InputResult read(final Map<String, Object> aMap) throws IOException {
		InputResult result = null;

		result = doRead(aMap);

		return result;
	}

	protected abstract void doOpen() throws IOException;

	protected abstract void doClose() throws IOException;

	protected abstract InputResult doRead(final Map<String, Object> aMap) throws IOException;

}
