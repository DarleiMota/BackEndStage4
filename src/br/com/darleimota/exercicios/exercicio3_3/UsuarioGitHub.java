package br.com.darleimota.exercicios.exercicio3_3;

public class UsuarioGitHub {
    private String login;
    private String name;
    private String bio;
    private String location;
    private int public_repos;
    private int followers;
    private int following;
    private String html_url;

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }

    public String getLocation() {
        return location;
    }

    public int getPublic_repos() {
        return public_repos;
    }

    public int getFollowers() {
        return followers;
    }

    public int getFollowing() {
        return following;
    }

    public String getHtml_url() {
        return html_url;
    }

    @Override
    public String toString() {
        return """
                ----------------------------------------------
                Nome: %s
                Usuário: %s
                Bio: %s
                Localização: %s
                Repositórios públicos: %d
                Seguidores: %d
                Seguindo: %d
                Perfil GitHub: %s
                ----------------------------------------------
                """.formatted(
                name != null ? name : "Não informado", login,
                bio != null ? bio : "Não informado",
                location != null ? location : "Não informado",
                public_repos,
                followers,
                following,
                html_url
        );
    }
}

