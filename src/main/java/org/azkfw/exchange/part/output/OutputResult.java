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
package org.azkfw.exchange.part.output;

/**
 * このクラスは、出力処理結果情報を保持するクラスです。
 * 
 * @since 1.0.0
 * @version 1.0.0 2014/07/14
 * @author Kawakicchi
 */
public class OutputResult {

	public static final OutputResult Success = new OutputResult(true);
	public static final OutputResult Error = new OutputResult(false);

	private boolean result;

	private OutputResult(final boolean aResult) {
		result = aResult;
	}

	/**
	 * 処理結果を判定する。
	 * 
	 * @return 判定結果
	 */
	public boolean isResult() {
		return result;
	}
}
