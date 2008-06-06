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
package com.google.gwt.maps.client.overlay;

import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.geom.LatLng;
import com.google.gwt.maps.client.geom.Point;
import com.google.gwt.maps.client.geom.Size;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.RootPanel;

import java.util.ArrayList;
import java.util.List;

/**
 * Tests the Marker class.
 */
public class MarkerTest extends GWTTestCase {
  // length of time to wait for asynchronous test to complete.
  static final int ASYNC_DELAY_MSEC = 5000;

  private static native String getNodeName(Element elem) /*-{
     return (elem.nodeName || "").toLowerCase();
  }-*/;

  @Override
  public String getModuleName() {
    return "com.google.gwt.maps.GoogleMapsTest";
  }

  /**
   * Removes all elements in the body, except scripts and iframes.
   */
  public void gwtSetUp() {
    Element bodyElem = RootPanel.getBodyElement();

    List<Element> toRemove = new ArrayList<Element>();
    for (int i = 0, n = DOM.getChildCount(bodyElem); i < n; ++i) {
      Element elem = DOM.getChild(bodyElem, i);
      String nodeName = getNodeName(elem);
      if (!"script".equals(nodeName) && !"iframe".equals(nodeName)) {
        toRemove.add(elem);
      }
    }

    for (int i = 0, n = toRemove.size(); i < n; ++i) {
      DOM.removeChild(bodyElem, toRemove.get(i));
    }
  }

  /**
   * Test Icon getters and setters.
   */
  public void testIconAccessors() {
    Icon ic = new Icon();
    
   Point pointA = new Point(10, 20);
    ic.setDragCrossAnchor(pointA);
    assertEquals("DragCrossAnchor", pointA, ic.getDragCrossAnchor());
    
    String dragCrossImage = "DragCrossImage";
    ic.setDragCrossImageURL(dragCrossImage);
    assertEquals("DragCrossImageURL", dragCrossImage, ic.getDragCrossImageUrl());
    
    Size size1 = new Size(20, 20);
    ic.setDragCrossSize(size1);
    assertEquals("DragCrossSize", size1, ic.getDragCrossSize());

    Point pointB = new Point(20, 30);
    ic.setIconAnchor(pointB);
    assertEquals("IconAnchor", pointB, ic.getIconAnchor());
    
    Size size2 = new Size(2, 2);
    ic.setIconSize(size2);
    assertEquals("IconSize", size2, ic.getIconSize());
    
    int[] map1 = {1, 2, 3, 4};
    ic.setImageMap(map1);
    assertEquals("ImageMap length", map1.length, ic.getImageMap().length);
    for (int i = 0; i < map1.length; i++) {
      assertEquals("ImageMap", map1[i], ic.getImageMap()[i]);
    }
    
    String dummyImage = "DummyImage";
    ic.setImageURL(dummyImage);
    assertEquals("ImageURL", dummyImage, ic.getImageURL());
    
    Point pointC = new Point(100,20);
    ic.setInfoWindowAnchor(pointC);
    assertEquals("InfoWindowAnchor", pointC, ic.getInfoWindowAnchor());

    ic.setMaxHeight(10);
    assertEquals("MaxHeight", 10, ic.getMaxHeight());
    
    dummyImage = "DummyMozPrintImage";
    ic.setMozPrintImageURL(dummyImage);
    assertEquals("MozPrintImageURL", dummyImage, ic.getMozPrintImageURL());
    
    dummyImage = "PrintImage";
    ic.setPrintImageURL(dummyImage);
    assertEquals("PrintImageURL", dummyImage, ic.getPrintImageURL());

    Size size3 = new Size(12, 34);
    ic.setShadowSize(size3);
    assertEquals("ShadowSize", size3, ic.getShadowSize());
    
    String dummyShadowURL = "DummyShadowURL";
    ic.setShadowURL(dummyShadowURL);
    assertEquals("Shadow URL", dummyShadowURL, ic.getShadowURL());
    
    String transparentUrl = "TransparentURL";
    ic.setTransparentImageURL(transparentUrl);
    assertEquals("TransarentURL", transparentUrl, ic.getTransparentImageURL());
  }

  /**
   * Test the default Icon() constructor.
   */
  public void testIconDefaultConstructor() {
    LatLng atlanta = new LatLng(33.7814790, -84.3880580);
    final MapWidget map = new MapWidget(atlanta, 13);
    map.setSize("300px", "300px");

    Icon ic = new Icon();
    ic.setImageURL("gnome-fs-home.png");
    MarkerOptions mo = new MarkerOptions();
    mo.setIcon(ic);
    Marker m = new Marker(new LatLng(33.7814790, -84.3880580), mo);
    map.addOverlay(m);
    RootPanel.get().add(map);
  }

  /**
   * Test the Icon(Icon) constructor.
   */
  public void testIconFromDefault() {
    LatLng atlanta = new LatLng(33.7814790, -84.3880580);
    final MapWidget map = new MapWidget(atlanta, 13);
    map.setSize("300px", "300px");

    Icon ic = new Icon(Icon.DEFAULT_ICON);
    ic.setIconSize(new Size(30, 30));
    MarkerOptions mo = new MarkerOptions();
    mo.setIcon(ic);
    Marker m = new Marker(new LatLng(33.7814790, -84.3880580), mo);
    map.addOverlay(m);
    RootPanel.get().add(map);
  }

  /**
   * Test the Icon(String) constructor.
   */
  public void testIconFromURL() {
    LatLng atlanta = new LatLng(33.7814790, -84.3880580);
    final MapWidget map = new MapWidget(atlanta, 13);
    map.setSize("300px", "300px");

    Icon ic = new Icon("gnome-fs-home.png");
    ic.setIconSize(new Size(30, 30));
    MarkerOptions mo = new MarkerOptions();
    mo.setIcon(ic);
    Marker m = new Marker(new LatLng(33.7814790, -84.3880580), mo);
    map.addOverlay(m);
    RootPanel.get().add(map);
  }
}
