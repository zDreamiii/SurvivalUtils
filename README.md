# SurvivalUtils  
This is a Quality of Life Plugin for Minecraft 1.21+ that adds useful commands to improve gameplay.

## Overview  
Currently, there are 10 commands available:

- `/survivalutils reload`, `/su reload` — Reloads the plugin configuration.
- `/heal` — Restores your health to full.  
- `/feed` — Fills your hunger bar completely.  
- `/repair` — Repairs the item you’re holding.
- `/rename <name>` — Renames the item you’re holding.
- `/craft`, `/workbench` — Opens a Crafting Table.
- `/anvil` — Opens an Anvil. Paper 1.21.1+ only.
- `/grindstone` — Opens a Grindstone. Paper 1.21.1+ only.
- `/enderchest`, `/ec` — Opens your Enderchest.
- `/gamemode <0-3|name>` — Changes your game mode using the classic Minecraft numbers (0 = Survival, 1 = Creative, 2 = Adventure, 3 = Spectator) or the usual game mode names.  
- Configurable cooldowns for commands (adjustable in config.yml)

## Installation  
1. Download the latest release from the Releases section.  
2. Place the `.jar` file into your server's `plugins` folder.  
3. Restart your server.

## Permissions  
Each command requires a specific permission node:

| Command                         | Permission                 |
|---------------------------------|----------------------------|
| `/survivalutils reload`, `/su`  | `survivalutils.admin`      |
| `/heal`                         | `survivalutils.heal`       |
| `/feed`                         | `survivalutils.feed`       |
| `/repair`                       | `survivalutils.repair`     |
| `/rename`                       | `survivalutils.rename`     |
| `/craft`, `/workbench`          | `survivalutils.workbench`  |
| `/anvil`                        | `survivalutils.anvil`      |
| `/grindstone`                   | `survivalutils.grindstone` |
| `/enderchest`, `/ec`            | `survivalutils.enderchest` |
| `/gamemode`                     | `survivalutils.gamemode`   |

Premium permission: `survivalutils.premium` — grants access to all regular SurvivalUtils commands without granting administrative permissions.

Admin permission: `survivalutils.admin` — grants access to `/survivalutils reload` and `/gamemode`.

**Default:** Server operators (op) have access to both permission groups.

Assign the appropriate permissions to your players or groups via your permissions plugin.

## Metrics

SurvivalUtils uses [bStats](https://bstats.org/) to collect anonymous usage statistics such as the server version, plugin version, player count and Java version. Server owners can disable metrics globally in `plugins/bStats/config.yml`.
