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
package org.azkfw.exchange.part.mapping;

import java.util.Map;

import org.azkfw.exchange.part.AbstractExchangePart;

/**
 * @since 1.0.0
 * @version 1.0.0 2014/07/14
 * @author Kawakicchi
 */
public abstract class AbstractMappingPart extends AbstractExchangePart implements MappingPart {

	/**
	 * コンストラクタ
	 */
	public AbstractMappingPart() {
		super(MappingPart.class);
	}

	/**
	 * コンストラクタ
	 * 
	 * @param aClass クラス
	 */
	public AbstractMappingPart(final Class<?> aClass) {
		super(aClass);
	}

	/**
	 * コンストラクタ
	 * 
	 * @param aName 名前
	 */
	public AbstractMappingPart(final String aName) {
		super(aName);
	}

	@Override
	public final MappingResult mapping(final Map<String, Object> aInputMap, final Map<String, Object> aOutputMap) {
		MappingResult result = null;
		result = doMapping(aInputMap, aOutputMap);
		return result;
	}

	/**
	 * マッピング処理を行なう。
	 * 
	 * @param aInputMap 入力マップ
	 * @param aOutputMap 出力マップ
	 * @return 結果
	 */
	protected abstract MappingResult doMapping(final Map<String, Object> aInputMap, final Map<String, Object> aOutputMap);

}
