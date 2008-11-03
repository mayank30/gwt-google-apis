/*
 * Copyright 2008 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.gwt.visualization.client;

import com.google.gwt.dom.client.Element;
import com.google.gwt.visualization.client.Table.DrawOptions;

/**
 * 
 *
 */
public class TableWidget extends AbstractVisualizationContainer<Table, DrawOptions> 
    implements Selectable {

  /**
   * Creates a table visualization widget. Call draw() to render it.
   */
  public TableWidget() {
    super();
  }

  /**
   * Creates the table visualization widget and draws the data table with the provided options.
   * @param data the table with the data.
   * @param options the drawing options.
   */
  public TableWidget(DataTable data, DrawOptions options) {
    super(data, options);
  }

  /** 
   * {@inheritDoc} 
   */
  public void addListener(SelectCallback callback) {
   getVisualization().addListener(callback);
  }

  /** 
   * {@inheritDoc} 
   */
  public Selection getSelection() {
    return getVisualization().getSelection();
  }

  /** 
   * {@inheritDoc} 
   */
  public void setSelection(Selection sel) {
    getVisualization().setSelection(sel);
  }

  @Override
  protected Table create(Element elem) {
    return Table.create(elem);
  }
}