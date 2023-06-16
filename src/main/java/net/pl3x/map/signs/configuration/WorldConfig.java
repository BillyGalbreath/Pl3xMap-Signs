/*
 * MIT License
 *
 * Copyright (c) 2020-2023 William Blake Galbreath
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package net.pl3x.map.signs.configuration;

import java.nio.file.Path;
import java.util.Locale;
import java.util.Map;
import libs.org.simpleyaml.configuration.ConfigurationSection;
import net.pl3x.map.core.configuration.AbstractConfig;
import net.pl3x.map.core.markers.Vector;
import net.pl3x.map.core.world.World;
import net.pl3x.map.signs.Pl3xMapSigns;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class WorldConfig extends AbstractConfig {
    @Key("layer.label")
    @Comment("""
            Label for map layer""")
    public String LAYER_LABEL = "Signs";
    @Key("layer.show-controls")
    @Comment("""
            Show controls for map layer""")
    public boolean LAYER_SHOW_CONTROLS = true;
    @Key("layer.default-hidden")
    @Comment("""
            Whether map layer is hidden by default""")
    public boolean LAYER_DEFAULT_HIDDEN = false;
    @Key("layer.update-interval")
    @Comment("""
            Update interval for map layer""")
    public int LAYER_UPDATE_INTERVAL = 5;
    @Key("layer.priority")
    @Comment("""
            Priority for map layer""")
    public int LAYER_PRIORITY = 99;
    @Key("layer.z-index")
    @Comment("""
            zIndex for map layer""")
    public int LAYER_ZINDEX = 99;
    @Key("layer.css")
    @Comment("""
            Custom CSS for the sign's layer.""")
    public String LAYER_CSS = """
            @import url('https://fonts.cdnfonts.com/css/minecraftia');
            div.leaflet-pl3xmap_acacia_sign_popup-pane,
            div.leaflet-pl3xmap_bamboo_sign_popup-pane,
            div.leaflet-pl3xmap_birch_sign_popup-pane,
            div.leaflet-pl3xmap_cherry_sign_popup-pane,
            div.leaflet-pl3xmap_crimson_sign_popup-pane,
            div.leaflet-pl3xmap_dark_oak_sign_popup-pane,
            div.leaflet-pl3xmap_jungle_sign_popup-pane,
            div.leaflet-pl3xmap_mangrove_sign_popup-pane,
            div.leaflet-pl3xmap_oak_sign_popup-pane,
            div.leaflet-pl3xmap_spruce_sign_popup-pane,
            div.leaflet-pl3xmap_warped_sign_popup-pane {
              z-index:999;
              pointer-events: none;
            }
            div.leaflet-pl3xmap_acacia_sign_popup-pane .leaflet-popup-content-wrapper::before,
            div.leaflet-pl3xmap_bamboo_sign_popup-pane .leaflet-popup-content-wrapper::before,
            div.leaflet-pl3xmap_birch_sign_popup-pane .leaflet-popup-content-wrapper::before,
            div.leaflet-pl3xmap_cherry_sign_popup-pane .leaflet-popup-content-wrapper::before,
            div.leaflet-pl3xmap_crimson_sign_popup-pane .leaflet-popup-content-wrapper::before,
            div.leaflet-pl3xmap_dark_oak_sign_popup-pane .leaflet-popup-content-wrapper::before,
            div.leaflet-pl3xmap_jungle_sign_popup-pane .leaflet-popup-content-wrapper::before,
            div.leaflet-pl3xmap_mangrove_sign_popup-pane .leaflet-popup-content-wrapper::before,
            div.leaflet-pl3xmap_oak_sign_popup-pane .leaflet-popup-content-wrapper::before,
            div.leaflet-pl3xmap_spruce_sign_popup-pane .leaflet-popup-content-wrapper::before,
            div.leaflet-pl3xmap_warped_sign_popup-pane .leaflet-popup-content-wrapper::before {
              content: "";
              position: absolute;
              top: -500vh;
              left: -500vw;
              width: 1000vw;
              height: 1000vh;
              backdrop-filter: blur(2px);
              background-color: rgba(0,0,0,0.5);
              z-index: -1;
            }
            div.leaflet-pl3xmap_acacia_sign_popup-pane div.leaflet-popup-content-wrapper {
              background-image: url('images/icon/registered/pl3xmap_acacia_sign_tooltip.png') !important;
            }
            div.leaflet-pl3xmap_bamboo_sign_popup-pane div.leaflet-popup-content-wrapper {
              background-image: url('images/icon/registered/pl3xmap_bamboo_sign_tooltip.png') !important;
            }
            div.leaflet-pl3xmap_birch_sign_popup-pane div.leaflet-popup-content-wrapper {
              background-image: url('images/icon/registered/pl3xmap_birch_sign_tooltip.png') !important;
            }
            div.leaflet-pl3xmap_cherry_sign_popup-pane div.leaflet-popup-content-wrapper {
              background-image: url('images/icon/registered/pl3xmap_cherry_sign_tooltip.png') !important;
            }
            div.leaflet-pl3xmap_crimson_sign_popup-pane div.leaflet-popup-content-wrapper {
              background-image: url('images/icon/registered/pl3xmap_crimson_sign_tooltip.png') !important;
            }
            div.leaflet-pl3xmap_dark_oak_sign_popup-pane div.leaflet-popup-content-wrapper {
              background-image: url('images/icon/registered/pl3xmap_dark_oak_sign_tooltip.png') !important;
            }
            div.leaflet-pl3xmap_jungle_sign_popup-pane div.leaflet-popup-content-wrapper {
              background-image: url('images/icon/registered/pl3xmap_jungle_sign_tooltip.png') !important;
            }
            div.leaflet-pl3xmap_mangrove_sign_popup-pane div.leaflet-popup-content-wrapper {
              background-image: url('images/icon/registered/pl3xmap_mangrove_sign_tooltip.png') !important;
            }
            div.leaflet-pl3xmap_oak_sign_popup-pane div.leaflet-popup-content-wrapper {
              background-image: url('images/icon/registered/pl3xmap_oak_sign_tooltip.png') !important;
            }
            div.leaflet-pl3xmap_spruce_sign_popup-pane div.leaflet-popup-content-wrapper {
              background-image: url('images/icon/registered/pl3xmap_spruce_sign_tooltip.png') !important;
            }
            div.leaflet-pl3xmap_warped_sign_popup-pane div.leaflet-popup-content-wrapper {
              background-image: url('images/icon/registered/pl3xmap_warped_sign_tooltip.png') !important;
            }
            div.leaflet-pl3xmap_acacia_sign_popup-pane div.leaflet-popup-content-wrapper,
            div.leaflet-pl3xmap_bamboo_sign_popup-pane div.leaflet-popup-content-wrapper,
            div.leaflet-pl3xmap_birch_sign_popup-pane div.leaflet-popup-content-wrapper,
            div.leaflet-pl3xmap_cherry_sign_popup-pane div.leaflet-popup-content-wrapper,
            div.leaflet-pl3xmap_crimson_sign_popup-pane div.leaflet-popup-content-wrapper,
            div.leaflet-pl3xmap_dark_oak_sign_popup-pane div.leaflet-popup-content-wrapper,
            div.leaflet-pl3xmap_jungle_sign_popup-pane div.leaflet-popup-content-wrapper,
            div.leaflet-pl3xmap_mangrove_sign_popup-pane div.leaflet-popup-content-wrapper,
            div.leaflet-pl3xmap_oak_sign_popup-pane div.leaflet-popup-content-wrapper,
            div.leaflet-pl3xmap_spruce_sign_popup-pane div.leaflet-popup-content-wrapper,
            div.leaflet-pl3xmap_warped_sign_popup-pane div.leaflet-popup-content-wrapper {
              margin: 0;
              padding: 0;
              border: 0;
              width: 196px !important;
              min-width: 196px;
              max-width: 196px;
              height: 210px !important;
              min-height: 210px;
              max-height: 210px;
              background: transparent;
              background-repeat: no-repeat;
              box-shadow: none;
            }
            div.leaflet-pl3xmap_acacia_sign_popup-pane div.leaflet-popup-content,
            div.leaflet-pl3xmap_bamboo_sign_popup-pane div.leaflet-popup-content,
            div.leaflet-pl3xmap_birch_sign_popup-pane div.leaflet-popup-content,
            div.leaflet-pl3xmap_cherry_sign_popup-pane div.leaflet-popup-content,
            div.leaflet-pl3xmap_crimson_sign_popup-pane div.leaflet-popup-content,
            div.leaflet-pl3xmap_dark_oak_sign_popup-pane div.leaflet-popup-content,
            div.leaflet-pl3xmap_jungle_sign_popup-pane div.leaflet-popup-content,
            div.leaflet-pl3xmap_mangrove_sign_popup-pane div.leaflet-popup-content,
            div.leaflet-pl3xmap_oak_sign_popup-pane div.leaflet-popup-content,
            div.leaflet-pl3xmap_spruce_sign_popup-pane div.leaflet-popup-content,
            div.leaflet-pl3xmap_warped_sign_popup-pane div.leaflet-popup-content {
              overflow: hidden !important;
              margin: 0;
              padding: 16px 14px 14px 14px !important;
              border: 0;
              width: 196px !important;
              min-width: 196px;
              max-width: 196px;
              height: 210px !important;
              min-height: 210px;
              max-height: 210px;
              font-family: 'Minecraftia', sans-serif;
              font-weight: 700;
              font-size:13px;
              line-height: 1.5;
              color: #000000;
            }
            div.leaflet-pl3xmap_acacia_sign_popup-pane div.leaflet-popup-tip-container,
            div.leaflet-pl3xmap_bamboo_sign_popup-pane div.leaflet-popup-tip-container,
            div.leaflet-pl3xmap_birch_sign_popup-pane div.leaflet-popup-tip-container,
            div.leaflet-pl3xmap_cherry_sign_popup-pane div.leaflet-popup-tip-container,
            div.leaflet-pl3xmap_crimson_sign_popup-pane div.leaflet-popup-tip-container,
            div.leaflet-pl3xmap_dark_oak_sign_popup-pane div.leaflet-popup-tip-container,
            div.leaflet-pl3xmap_jungle_sign_popup-pane div.leaflet-popup-tip-container,
            div.leaflet-pl3xmap_mangrove_sign_popup-pane div.leaflet-popup-tip-container,
            div.leaflet-pl3xmap_oak_sign_popup-pane div.leaflet-popup-tip-container,
            div.leaflet-pl3xmap_spruce_sign_popup-pane div.leaflet-popup-tip-container,
            div.leaflet-pl3xmap_warped_sign_popup-pane div.leaflet-popup-tip-container {
              display: none;
            }
            div.leaflet-pl3xmap_acacia_sign_popup-pane div,
            div.leaflet-pl3xmap_bamboo_sign_popup-pane div,
            div.leaflet-pl3xmap_birch_sign_popup-pane div,
            div.leaflet-pl3xmap_cherry_sign_popup-pane div,
            div.leaflet-pl3xmap_crimson_sign_popup-pane div,
            div.leaflet-pl3xmap_dark_oak_sign_popup-pane div,
            div.leaflet-pl3xmap_jungle_sign_popup-pane div,
            div.leaflet-pl3xmap_mangrove_sign_popup-pane div,
            div.leaflet-pl3xmap_oak_sign_popup-pane div,
            div.leaflet-pl3xmap_spruce_sign_popup-pane div,
            div.leaflet-pl3xmap_warped_sign_popup-pane div {
              transition: all 0.25s;
            }
            center.pl3xmap_signs_popup {
              pointer-events: auto;
              min-width: 168px;
              min-height: 80px;
            }""";

    @Key("marker.icon.size")
    @Comment("""
            The size (in pixels) the icon should be.""")
    public Vector ICON_SIZE = new Vector(20, 20);

    @Key("marker.popup.content")
    @Comment("""
            Contents of the icon's popup.""")
    public String ICON_POPUP_CONTENT = """
            <center class="pl3xmap_signs_popup">
              <line1><br/>
              <line2><br/>
              <line3><br/>
              <line4>
            </center>""";

    @Key("sign.add.particles")
    @Comment("""
            The particles to play when a sign is added to Pl3xMap.
            https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Particle.html""")
    public Particle SIGN_ADD_PARTICLES = Particle.VILLAGER_HAPPY;
    @Key("sign.add.sound")
    @Comment("""
            The sound to play when a sign is added to Pl3xMap.
            https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Sound.html""")
    public Sound SIGN_ADD_SOUND = Sound.ENTITY_PLAYER_LEVELUP;
    @Key("sign.remove.particles")
    @Comment("""
            The particles to play when a sign is removed from Pl3xMap.
            https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Particle.html""")
    public Particle SIGN_REMOVE_PARTICLES = Particle.WAX_ON;
    @Key("sign.remove.sound")
    @Comment("""
            The sound to play when a sign is removed from Pl3xMap.
            https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Sound.html""")
    public Sound SIGN_REMOVE_SOUND = Sound.ENTITY_GHAST_HURT;

    private final World world;

    public WorldConfig(@NotNull World world) {
        this.world = world;
        reload();
    }

    public @NotNull World getWorld() {
        return this.world;
    }

    public void reload() {
        Path mainDir = Pl3xMapSigns.getPlugin(Pl3xMapSigns.class).getDataFolder().toPath();
        reload(mainDir.resolve("config.yml"), WorldConfig.class);
    }

    @Override
    protected @NotNull Object getClassObject() {
        return this;
    }

    @Override
    protected @Nullable Object getValue(@NotNull String path, @Nullable Object def) {
        if (getConfig().get("world-settings.default." + path) == null) {
            set("world-settings.default." + path, def);
        }
        return get("world-settings." + this.world.getName() + "." + path,
                get("world-settings.default." + path, def));
    }

    @Override
    protected void setComment(@NotNull String path, @Nullable String comment) {
        getConfig().setComment("world-settings.default." + path, comment);
    }

    @Override
    protected @Nullable Object get(@NotNull String path) {
        Object value = getConfig().get(path);
        if (value == null) {
            return null;
        }
        String subpath = path.substring(path.indexOf(".", path.indexOf(".") + 1) + 1);
        switch (subpath) {
            case "marker.icon.size" -> {
                if (value instanceof ConfigurationSection section) {
                    return Vector.of(section.getDouble("x"), section.getDouble("z"));
                } else if (value instanceof Map<?, ?>) {
                    @SuppressWarnings("unchecked")
                    Map<String, Double> map = (Map<String, Double>) value;
                    return Vector.of(map.get("x"), map.get("z"));
                }
            }
            case "sign.add.particles", "sign.remove.particles" -> {
                try {
                    return Particle.valueOf(value.toString().toUpperCase(Locale.ROOT));
                } catch (Throwable t) {
                    t.printStackTrace();
                    return null;
                }
            }
            case "sign.add.sound", "sign.remove.sound" -> {
                try {
                    return Sound.valueOf(value.toString().toUpperCase(Locale.ROOT));
                } catch (Throwable t) {
                    t.printStackTrace();
                    return null;
                }
            }
        }
        return super.get(path);
    }

    @Override
    protected void set(@NotNull String path, @Nullable Object value) {
        if (value instanceof Vector vector) {
            value = Map.of("x", vector.x(), "z", vector.z());
        } else if (value instanceof Enum<?> enumeration) {
            value = enumeration.name();
        }
        getConfig().set(path, value);
    }
}
