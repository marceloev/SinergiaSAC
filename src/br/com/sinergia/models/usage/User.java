package br.com.sinergia.models.usage;

public class User {

    private static User current = new User();

    private int codUsu;
    private String loginUsu;
    private String senhaUsu;

    public User() {
        this.setCodUsu(0);
        this.setLoginUsu("");
        this.setSenhaUsu("");
    }

    public User(int codUsu, String loginUsu, String senhaUsu) {
        this.setCodUsu(codUsu);
        this.setLoginUsu(loginUsu);
        this.setSenhaUsu(senhaUsu);
    }

    public static User getCurrent() {
        return current;
    }

    public static void setCurrent(User current) {
        User.current = current;
    }

    public int getCodUsu() {
        return codUsu;
    }

    public void setCodUsu(int codUsu) {
        this.codUsu = codUsu;
    }

    public String getLoginUsu() {
        return loginUsu;
    }

    public void setLoginUsu(String loginUsu) {
        this.loginUsu = loginUsu;
    }

    public String getSenhaUsu() {
        return senhaUsu;
    }

    public void setSenhaUsu(String senhaUsu) {
        this.senhaUsu = senhaUsu;
    }
}
