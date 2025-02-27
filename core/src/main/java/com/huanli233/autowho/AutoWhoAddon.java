package com.huanli233.autowho;

import net.labymod.api.Laby;
import net.labymod.api.addon.LabyAddon;
import net.labymod.api.models.addon.annotation.AddonMain;
import com.huanli233.autowho.listener.ChatListener;

@AddonMain
public class AutoWhoAddon extends LabyAddon<AutoWhoConfiguration> {

  @Override
  protected void enable() {
    this.registerSettingCategory();
    this.registerListener(new ChatListener(this));
  }

  public void checkAndSend(String message) {
    if (message.contains(configuration().keyword.getOrDefault(AutoWhoConfiguration.DEFAULT_KEYWORD)) &&
        !message.contains(configuration().exclude.getOrDefault(":"))) {
      Laby.references().chatExecutor().chat("/who", false);
    }
  }

  @Override
  protected Class<AutoWhoConfiguration> configurationClass() {
    return AutoWhoConfiguration.class;
  }
}
