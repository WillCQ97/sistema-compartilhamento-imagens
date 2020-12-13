package br.ufes.sgi.presenter;

import br.ufes.sgi.view.TelaPrincipalView;

public class TelaPrincipalPresenter {
    
    private TelaPrincipalView view;
   
    
    public TelaPrincipalPresenter(String nomeUsuario, String tipoUsuario) throws Exception{
        view = new TelaPrincipalView();
        
        view.getTxtNomeUsuario().setText(nomeUsuario);
        view.getTxtTipoUsuario().setText(tipoUsuario);
        
        view.setVisible(true);
        
        
    }
}
