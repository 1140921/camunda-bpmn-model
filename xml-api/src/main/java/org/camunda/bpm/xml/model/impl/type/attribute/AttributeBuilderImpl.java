/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.camunda.bpm.xml.model.impl.type.attribute;

import org.camunda.bpm.xml.model.Model;
import org.camunda.bpm.xml.model.impl.ModelBuildOperation;
import org.camunda.bpm.xml.model.impl.type.ModelElementTypeImpl;
import org.camunda.bpm.xml.model.type.Attribute;
import org.camunda.bpm.xml.model.type.AttributeBuilder;


/**
 *
 * @author Daniel Meyer
 *
 */
public abstract class AttributeBuilderImpl<T> implements AttributeBuilder<T>, ModelBuildOperation {

  final AttributeImpl<T> attribute;
  private final ModelElementTypeImpl modelType;

  AttributeBuilderImpl(String attributeName, ModelElementTypeImpl modelType, AttributeImpl<T> attribute) {
    this.modelType = modelType;
    this.attribute = attribute;
    attribute.setAttributeName(attributeName);
  }

  public AttributeBuilder<T> idAttribute() {
    attribute.setId();
    return this;
  }


  public AttributeBuilder<T> defaultValue(T defaultValue) {
    attribute.setDefaultValue(defaultValue);
    return this;
  }

  public AttributeBuilder<T> required() {
    attribute.setRequired();
    return this;
  }

  public Attribute<T> build() {
    modelType.registerAttribute(attribute);
    return attribute;
  }

  public void performModelBuild(Model model) {
    // do nothing
  }

}