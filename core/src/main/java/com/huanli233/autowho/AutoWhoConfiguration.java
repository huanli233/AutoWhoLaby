package com.huanli233.autowho;

import net.labymod.api.addon.AddonConfig;
import net.labymod.api.client.gui.screen.widget.widgets.input.SwitchWidget;
import net.labymod.api.client.gui.screen.widget.widgets.input.TextFieldWidget;
import net.labymod.api.configuration.loader.annotation.ConfigName;
import net.labymod.api.configuration.loader.property.ConfigProperty;

@ConfigName("settings")
public class AutoWhoConfiguration extends AddonConfig {

  public static final String DEFAULT_KEYWORD = "Protect your bed and destroy the enemy beds.";

  @SwitchWidget.SwitchSetting
  private final ConfigProperty<Boolean> enabled = new ConfigProperty<>(true);

  @TextFieldWidget.TextFieldSetting
  public final ConfigProperty<String> keyword = new ConfigProperty<>(DEFAULT_KEYWORD);

  @TextFieldWidget.TextFieldSetting
  public final ConfigProperty<String> exclude = new ConfigProperty<>(":");

  @Override
  public ConfigProperty<Boolean> enabled() {
    return this.enabled;
  }
}
