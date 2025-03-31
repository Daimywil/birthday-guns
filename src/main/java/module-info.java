module BirthdayGuns {
    requires hanyaeger;
    requires java.desktop;

    exports org;
    exports org.maps;

    opens sprites.guns.applepie;
    opens sprites.maps.thebackyard;
    opens sprites.characters;
    exports org.maps.Tiles;
}