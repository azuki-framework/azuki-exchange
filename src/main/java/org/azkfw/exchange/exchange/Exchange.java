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

import org.azkfw.exchange.part.input.InputPart;
import org.azkfw.exchange.part.output.OutputPart;

/**
 * このインターフェースは、エクスチェンジ機能を定義したインターフェースです。
 * 
 * @since 1.0.0
 * @version 1.0.0 2014/07/14
 * @author Kawakicchi
 */
public interface Exchange<INPUT extends InputPart, OUTPUT extends OutputPart> {

	/**
	 * 入力機能をサポートするか判断する。
	 * 
	 * @return 判断結果
	 */
	public boolean isSupportInput();

	/**
	 * 出力機能をサポートするか判断する。
	 * 
	 * @return　判断結果
	 */
	public boolean isSupportOutput();

	/**
	 * 入力機能を生成する。
	 * 
	 * @return　入力機能
	 */
	public INPUT generateInputPart();

	/**
	 * 出力機能を生成する。
	 * 
	 * @return 出力機能
	 */
	public OUTPUT generateOutputPart();

}
