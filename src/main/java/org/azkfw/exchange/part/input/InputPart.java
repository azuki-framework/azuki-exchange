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

import org.azkfw.exchange.part.ExchangePart;

/**
 * このインターフェースは、入力パート機能を定義するインターフェースです。
 * 
 * @since 1.0.0
 * @version 1.0.0 2014/07/14
 * @author Kawakicchi
 */
public interface InputPart extends ExchangePart {

	/**
	 * オープン処理を行なう。
	 * 
	 * @throws IOException IO操作に起因する問題が発生した場合
	 */
	public void open() throws IOException;

	/**
	 * クローズ処理を行なう。
	 * 
	 * @throws IOException IO操作に起因する問題が発生した場合
	 */
	public void close() throws IOException;

	/**
	 * 読み込み処理を行なう。
	 * 
	 * @param aMap 入力マップ
	 * @return 処理結果情報
	 * @throws IOException
	 */
	public InputResult read(final Map<String, Object> aMap) throws IOException;
}
