module BirthdayGuns {
    requires hanyaeger;
    requires java.desktop;
    requires com.google.errorprone.annotations;

    exports org;
    exports org.maps;

    opens sprites.guns.applepie;
    opens sprites.guns.soesjes;
    opens sprites.maps.thebackyard;
    opens sprites.characters;
    exports org.maps.Tiles;
}