/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.sgi.command;

import br.ufes.sgi.model.ImagemMemento;

/**
 *
 * @author 55289
 */
public interface ImagemCommandMemento {

    public void restaurar(ImagemMemento memento);

    public ImagemMemento criar();
}
