module BirthdayGuns {
    requires hanyaeger;
    requires java.desktop;

    exports org;
    exports org.maps;

    opens sprites;
    opens sprites.guns.applepie;
}