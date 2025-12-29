# SurvivalUtils  
This is a Quality of Life Plugin for Minecraft 1.21+ that adds useful commands to improve gameplay.

## Overview  
Currently, there are 5 commands available:

- `/heal` — Restores your health to full. Requires permission `survivalutils.heal`.  
- `/feed` — Fills your hunger bar completely. Requires permission `survivalutils.feed`.  
- `/repair` — Repairs the item you’re holding. Requires permission `survivalutils.repair`.
- `/craft` — Opens the crafting table. Requires permission `survivalutils.workbench`.
- `/gamemode <0-3|name>` — Changes your game mode using the classic Minecraft numbers (0 = Survival, 1 = Creative, 2 = Adventure, 3 = Spectator) or the usual game mode names. Requires permission `survivalutils.gamemode`.  
  *This command brings back the original numeric way to switch game modes!*

## Installation  
1. Download the latest release from the Releases section.  
2. Place the `.jar` file into your server's `plugins` folder.  
3. Restart your server.

## Permissions  
Each command requires a specific permission node:

| Command      | Permission                 |  
|--------------|----------------------------|  
| `/heal`      | `survivalutils.heal`       |  
| `/feed`      | `survivalutils.feed`       |  
| `/repair`    | `survivalutils.repair`     |  
| `/craft`     | `survivalutils.workbench`  | 
| `/gamemode`  | `survivalutils.gamemode`   |  

There is also a wildcard permission: `survivalutils.*` — this grants access to **all commands** and is by default assigned to server operators (`op`).

Make sure to assign the appropriate permissions to your players or groups via your permissions plugin.
