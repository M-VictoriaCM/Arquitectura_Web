package main;


import repository.RepositoryFactory;

public class app {
    public static void main(String[] args) {
        RepositoryFactory.getInstance(RepositoryFactory.MYSQL);
    }
}

