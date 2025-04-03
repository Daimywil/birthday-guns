package org.entities.drop;

import org.entities.characters.PlayerCharacter;
import org.guns.Gun;

import com.github.hanyaeger.api.Coordinate2D;

public class GunDrop extends Drop {
    private Gun gun;

    public GunDrop(Gun gun, Coordinate2D initialLocation) {
        super(gun.getResource(), initialLocation);
        this.gun = gun;
    }

    @Override
    protected void grantDrop(PlayerCharacter player) {
        player.swapGun(gun);
    }
}
