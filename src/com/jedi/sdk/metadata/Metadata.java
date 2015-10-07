/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jedi.sdk.metadata;

import java.util.List;

/**
 *
 * @author umit
 */
public interface Metadata {

    List<Metadata> getChildren();
    String getName();
    void setName(String name);
    void addChild(Metadata child);
}
