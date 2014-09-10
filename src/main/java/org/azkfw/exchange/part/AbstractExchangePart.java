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
package org.azkfw.exchange.part;

import org.azkfw.lang.LoggingObject;

/**
 * このクラスは、パートを定義するするための基底クラスです。
 * 
 * @since 1.0.0
 * @version 1.0.0 2014/07/14
 * @author Kawakicchi
 */
public abstract class AbstractExchangePart extends LoggingObject implements ExchangePart {

	/**
	 * コンストラクタ
	 */
	public AbstractExchangePart() {
		super(ExchangePart.class);
	}

	/**
	 * コンストラクタ
	 * 
	 * @param aClass クラス
	 */
	public AbstractExchangePart(final Class<?> aClass) {
		super(aClass);
	}

	/**
	 * コンストラクタ
	 * 
	 * @param aName 名前
	 */
	public AbstractExchangePart(final String aName) {
		super(aName);
	}

	@Override
	public void initialize() {
		doInitialize();
	}

	@Override
	public void release() {
		doRelease();
	}

	/**
	 * 初期化処理を行う。
	 */
	public abstract void doInitialize();

	/**
	 * 解放処理を行う。
	 */
	public abstract void doRelease();
}
