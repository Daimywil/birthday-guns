module BirthdayGuns {
    requires hanyaeger;
    requires java.desktop;
    requires com.google.errorprone.annotations;

    exports org;
    exports org.maps;

    opens sprites.guns.applepie;
    opens sprites.guns.soesjes;
    opens sprites.maps.thebackyard;
    opens sprites.maps.thedungeon;
    opens sprites.maps.icons;
    opens sprites.characters;
    opens sprites.guns.weddingcake;
    exports org.maps.tiles;
}