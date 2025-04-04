/*
 *    Copyright 2009-2022 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       https://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.submitted.handle_by_jdbc_type;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

public interface Mapper {

  BoolsBean getBools(Integer id);

  @Result(id = true, column = "id", property = "id")
  @Result(column = "b2", property = "b2")
  @Result(column = "b2", property = "c")
  @Select("select b2 from bools where id = #{id}")
  BoolsBean getBoolsSameColumnToDifferentProperty(Integer id);

  @Result(id = true, column = "id", property = "id")
  @Result(column = "b1", property = "b1")
  @Result(column = "b2", property = "b1")
  @Select("select b1, b2 from bools where id = #{id}")
  BoolsBean getBoolsDifferentColumnToSameProperty(Integer id);

  void insertBools(BoolsBean user);

}
