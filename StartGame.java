package advent;
import java.util.*;
public class StartGame {
	
	

		
		public String hero_name;
		public String enemy;
		private int hero_attackDmg;
		private int enemy_attackDmg;
		private int enemy_magicDmg;
		private int enemy_hp;
		private int hero_mp;
		private int total_hmp;
		private int enemy_mp;
		private int hero_maxHealth;
		private int hero_magicDmg;
		private int healthPotion_dropChance = 50;
		private int magicPotion_dropChance = 40;
		private int hero_exp = 0;
		private static int missChance = 90;
		private int hero_ability;
		private int healthPotion = 0;
		private int magicPotion = 0;
		private int hero_lvl = 1;
		private int enemy_skillChance = 50;
		private short enemy_skillCost;
		private String mage_skills[];
		private String warrior_skills[];
		private String orc_skills[];
		private int totalDmg = 0;
		
		Scanner in = new Scanner(System.in);
		static Random rand = new Random();
		
		public StartGame(String name1) {
			
			try {
				Thread.sleep(2000);
			}catch(Exception e) {
				System.out.println(e);
			}
			
			try {
				
				System.out.println("\t\t\t\tGame loading...");
				System.out.print("\t\t\t  ");
				for(int i = 1; i <=50; i+=2) {
				Thread.sleep(500);
				System.out.print("•");
				}
				System.out.println();
				Thread.sleep(5000);
				
			}catch(Exception e) {
				
				System.out.println(e);
				
			}
			
			char select;
			
			
			this.hero_name = name1;
			
			//Loop for game option
			OPTION:
			do {
			greet_user();
			
			select = in.next().charAt(0);
			boolean running = true;
			if(select == '1') {
//				game();
				
				int max = 100;
				int min = 75;
				int range  = max - min + 1;
				select_hero();
				in.nextLine();
				
				//loop while game is running
				START:
				while(running) {
					//enemy variables	
					
				String enemy_list[] = {"Zombie","Assassin","Troll","Goblin","Serpent","Giant Sting Bee","Warlord"};
				this.enemy_hp = (int)(Math.random() * range)+ min;
				this.enemy = enemy_list[rand.nextInt(enemy_list.length)];
				set_enemyStats();
				
				System.out.println("\tDiscovering dungeon...\n");

				try {
					Thread.sleep(1000);
				}catch(Exception e) {
					System.out.println(e);
				}
				
				System.out.println("\tFinding enemies to fight...\n");
				
				try {
					Thread.sleep(1000);
				}catch(Exception e) {
					System.out.println(e);
				}
				
				System.out.println("\tYou found an enemy...\n");
				
				try {
					Thread.sleep(1000);
				}catch(Exception e) {
					System.out.println(e);
				}
				
				System.out.println("\tPrepare yourself...\n");
				
				try {
					Thread.sleep(1000);
				}catch(Exception e) {
					System.out.println(e);
				}
				
				System.out.println("\tEnemy initiated!\n");
				
				try {
					Thread.sleep(2000);
				}catch(Exception e) {
					System.out.println(e);
				}
				
				System.out.println("\t-------------------------------------------------------------------------\n");
				System.out.println("\t\t\t\tAn enemy has appeared!");
				System.out.println("\t\t\t\t"+enemy + " (" + enemy_hp + " hp) (" + enemy_mp + " mp) ");
				System.out.println("\n\t-------------------------------------------------------------------------");

				//SELECT COMMAND
				//loop while enemy health > 0
				COMMAND:
				while(enemy_hp > 0) {
					try {
						Thread.sleep(2000);
					}catch(Exception e) {
						System.out.println(e);
					}
					if(hero_maxHealth < 1) {
						System.out.println("\tYou are low on health! Game Over!");
						System.exit(0);
					}
					System.out.println();
					try {
						System.out.print("\t");
						for(int i=1;i<=6;i++) {
							Thread.sleep(100);
							System.out.print("");

							System.out.print(">>\t");
						}
					}catch(Exception e) {
						System.out.println(e);
					}
					
					
				System.out.println("\n\n\t" + hero_name + "\n"+ "\tHP: " + hero_maxHealth + "\n\tMP: "+ hero_mp);
				System.out.println("\n\tWhat would you like to do: ");
				System.out.println("\tPress:\n\n\t[w] Attack\n\t[x] Abilities\n\t[y] Use potion\n\t[z] Escape");
				String command = in.nextLine();
				hero_ab(hero_ability);
				if(command.equalsIgnoreCase("w") || command.equalsIgnoreCase("Attack")) {
				hero_attack();
				if(enemy_hp >= 1) {
					enemy_turn();
				}
				}else if(command.equalsIgnoreCase("x") || command.equalsIgnoreCase("abilities")) {
					//use abilities
					
					String ability;
					if(this.hero_ability == 1) {
						mage_abilities();
						System.out.println("\t[x] return");
						ability = in.nextLine();
						if(ability.equalsIgnoreCase("a")) {
							int mp_cost = 35;
							if(hero_mp < mp_cost) {
								System.out.println("\tNot enough mana!");
								
								
								
							}else {
							frost_bite();
							hero_mp -= mp_cost;
							if(enemy_hp >= 1) {
								enemy_turn();
							}
							}
						}else if(ability.equalsIgnoreCase("b")) {
							int mp_cost = 50;
							if(hero_mp < mp_cost) {
								System.out.println("\tNot enough mana!");
							}else {
							crescent_flare();
							
							hero_mp -= mp_cost;
							if(enemy_hp >= 1) {
								enemy_turn();
								
							}
							}
							
							
						}else if(ability.equalsIgnoreCase("c")) {
							int mp_cost = 70;
							if(hero_mp < mp_cost) {
								System.out.println("\tNot enough mana!");
							}else {
							thunder_reign();
							
							hero_mp -= mp_cost;
							if(enemy_hp >= 1) {
								enemy_turn();
							}
							}
							
							
						}else if(ability.equalsIgnoreCase("d")) {
							int mp_cost = 85;
							if(hero_mp < mp_cost) {
								System.out.println("\tNot enough mana!");
							}else {
							howl();
							
							hero_mp -= mp_cost;
							if(enemy_hp >= 1) {
								enemy_turn();
							}
							}
							
							
						}else if(ability.equalsIgnoreCase("e")) {
							int mp_cost = 100;
							if(hero_mp < mp_cost) {
								System.out.println("\tNot enough mana!");
							}else {
							white_apocalypse();
							
							hero_mp -= mp_cost;
							if(enemy_hp >= 1) {
								enemy_turn();
							}
							}
							
							
						}else if(ability.equalsIgnoreCase("x")) {
							continue COMMAND; 
						}else {
							System.out.println("\tInvalid command");
						}
						
						}else if(this.hero_ability == 2) {
							
							warrior_abilities();
							ability = in.nextLine();
							if(ability.equalsIgnoreCase("a")) {
								int mp_cost = 10;
								if(hero_mp < mp_cost) {
									System.out.println("\tNot enough mana! ");
									continue COMMAND;
								}else {
								slice_dice();
								hero_mp -= mp_cost;
								if(enemy_hp >= 1) {
									enemy_turn();
								}
								}
							
						}else if(ability.equalsIgnoreCase("b")) {
							int mp_cost = 15;
							if(hero_mp < mp_cost) {
								System.out.println("\tNot enough mana! ");
								continue COMMAND;
							}else {
							blade_spin();
							hero_mp -= mp_cost;
							if(enemy_hp >= 1) {
								enemy_turn();
							}
							}
						
					}else if(ability.equalsIgnoreCase("c")) {
						int mp_cost = 20;
						if(hero_mp < mp_cost) {
							System.out.println("\tNot enough mana! ");
							continue COMMAND;
						}else {
						soaring_vortex();
						hero_mp -= mp_cost;
						if(enemy_hp >= 1) {
							enemy_turn();
						}
						}
					
				}else if(ability.equalsIgnoreCase("d")) {
					int mp_cost = 25;
					if(hero_mp < mp_cost) {
						System.out.println("\tNot enough mana! ");
						continue COMMAND;
					}else {
					ethereal_blade();
					hero_mp -= mp_cost;
					if(enemy_hp >= 1) {
						enemy_turn();
					}
					}
				
			}else if(ability.equalsIgnoreCase("e")) {
				int mp_cost = 30;
				if(hero_mp < mp_cost) {
					System.out.println("\tNot enough mana! ");
					continue COMMAND;
				}else {
				dimension_slash();
				hero_mp -= mp_cost;
				if(enemy_hp >= 1) {
					enemy_turn();
				}
				}
			
		}
						
					
					}else if(this.hero_ability == 3) {
						
						orc_abilities();
						ability = in.nextLine();
						if(ability.equalsIgnoreCase("a")) {
							int mp_cost = 20;
							if(hero_mp < mp_cost) {
								System.out.println("\tNot enough mana! ");
								continue COMMAND;
							}else {
							berserk();
							hero_mp -= mp_cost;
							if(enemy_hp >= 1) {
								enemy_turn();
							}
							}
						
					}else if(ability.equalsIgnoreCase("b")) {
						int mp_cost = 25;
						if(hero_mp < mp_cost) {
							System.out.println("\tNot enough mana! ");
							continue COMMAND;
						}else {
						fatal_end();
						hero_mp -= mp_cost;
						if(enemy_hp >= 1) {
							enemy_turn();
						}
						}
					
				}else if(ability.equalsIgnoreCase("c")) {
					int mp_cost = 30;
					if(hero_mp < mp_cost) {
						System.out.println("\tNot enough mana! ");
						continue COMMAND;
					}else {
					myriad_blades();
					hero_mp -= mp_cost;
					if(enemy_hp >= 1) {
						enemy_turn();
					}
					}
				
			}else if(ability.equalsIgnoreCase("d")) {
				int mp_cost = 40;
				if(hero_mp < mp_cost) {
					System.out.println("\tNot enough mana! ");
					continue COMMAND;
				}else {
				counter_strike();
				hero_mp -= mp_cost;
				if(enemy_hp >= 1) {
					enemy_turn();
				}
				}
			
		}else if(ability.equalsIgnoreCase("e")) {
			int mp_cost = 45;
			if(hero_mp < mp_cost) {
				System.out.println("\tNot enough mana! ");
				continue COMMAND;
			}else {
			agnerastriya();
			hero_mp -= mp_cost;
			if(enemy_hp >= 1) {
				enemy_turn();
			}
			}
		
	}
						
					
				
				}
				}else if(command.equalsIgnoreCase("y") || command.equalsIgnoreCase("use potion")) {
					//use potion
					boolean pt = true;
					PTN:
					
					while(pt) {
					System.out.println("\tSelect Potion:");
					System.out.println("\t[1] Health potion: " + this.healthPotion + "x");
					System.out.println("\t[2] Magic potion: " + this.magicPotion + "x");
					System.out.println("\n\t[x]return");
					char potion = in.next().charAt(0);
					in.nextLine();
					if(potion == '1') {
						if(healthPotion > 0) {
								this.hero_maxHealth += 50;
								try {
									
									Thread.sleep(2000);
									
								}catch(Exception e) {
									
									System.out.println(e);
									
								}
								try {
									for(int i=1;i<=6;i++) {
										Thread.sleep(100);
										System.out.print("\t");

										System.out.print(">>");
									}
								}catch(Exception e) {
									System.out.println(e);
								}
								
								System.out.println();
								System.out.println("\n\tYou used health potion, health points has been restored by 50");
								healthPotion--;
								pt = false;
						}else {
							System.out.println("\tNot enough potion!");
							
							continue PTN;
						}
					}else if(potion == '2') {
						if(magicPotion > 0) {
							
							this.hero_mp += 50;
							try {
								
								Thread.sleep(2000);
								
							}catch(Exception e) {
								
								System.out.println(e);
								
							}
							try {
								for(int i=1;i<=6;i++) {
									Thread.sleep(100);
									System.out.print("\t");

									System.out.print(">>");
								}
							}catch(Exception e) {
								System.out.println(e);
							}
							
							System.out.println();
							System.out.println("\n\tYou used magic potion, magic points has been restored by 50");
							magicPotion--;
							pt = false;
							
					}else {
						System.out.println("\tNot enough potion!");
						
						continue PTN;
					}
						
					}else if(potion == 'x'){
						
						continue COMMAND;
						
					}else {
						System.out.println("\tInvalid!");
					}
					}//while loop;
					if(enemy_hp >= 1) {
						enemy_turn();
					}
					
				}else if(command.equalsIgnoreCase("z") || command.equalsIgnoreCase("escape")) {
					try {
						
						Thread.sleep(2000);
						
					}catch(Exception e) {
						
						System.out.println(e);
						
					}
					System.out.println("\tYou ran away from the enemy!");
					try {
						
						Thread.sleep(1000);
						
					}catch(Exception e) {
						
						System.out.println(e);
						
					}
					System.out.println("\tDo you want to enter battle again?(Y/N) : ");
					String yn = in.nextLine();
					if(yn.equalsIgnoreCase("y")) {
						System.out.println("\tContinuing journey...");
						try {
							
							Thread.sleep(2000);
							
						}catch(Exception e) {
							
							System.out.println(e);
							
						}
						continue START; 
					}else if (yn.equalsIgnoreCase("N")){
						set_heroExp(1);
						set_heroLvl(1);
						set_mage(60,80,75,150);
						set_warrior(80, 60, 85, 50);
						set_orc(70, 65, 150, 60);
						System.out.println("\tReturning to main menu");
						try {
							
							Thread.sleep(2000);
							
						}catch(Exception e) {
							
							System.out.println(e);
							
						}
						continue OPTION;
					}else {
						System.out.println("Invalid command!");
					}
					
				}else {
					
					System.out.println("Invalid command");
					
				}
						
			   	
				if(enemy_hp < 1) {
					
					int exp = hero_exp += 100; //
					System.out.println("\tYour exp: "+ exp);
					int drop = rand.nextInt(100);
					int randHP = rand.nextInt(30);
					int randMP = rand.nextInt(20);
					hero_maxHealth += randHP;
					hero_mp += randMP;
					System.out.println("\n\tYou recovered a small amount of HP & MP");
					try {
						Thread.sleep(1000);
					}catch(Exception e) {
						System.out.println(e);
					}
					if(healthPotion_dropChance > drop) {
						try {
							Thread.sleep(1000);
						}catch(Exception e) {
							System.out.println(e);
						}
						System.out.println("\tThe enemy dropped a health potion.");
						
						//quantity
						healthPotion++;
						System.out.println("\n\tremaining potion(s): " + healthPotion);
					}
					if(magicPotion_dropChance > drop) {
						try {
							Thread.sleep(1000);
						}catch(Exception e) {
							System.out.println(e);
						}
						System.out.println("\n\tThe enemy dropped a magic potion.");
						//quantity
						magicPotion++;
						System.out.println("\n\tremaining potion(s): " + magicPotion);

					}
					if(exp >= hero_lvl * 100) {
						hero_lvl++;
						System.out.println("\n\tLevel up!");
						try {
							Thread.sleep(2000);
						}catch(Exception e) {
							System.out.println(e);
						}
						if(hero_lvl <= 5) {
						if(hero_ability == 1) {
							array_skills();
						System.out.println("\n\tYou unlocked a new skill! ");
						try {
							Thread.sleep(2000);
						}catch(Exception e) {
							System.out.println(e);
						}
						System.out.println("\t>> " + mage_skills[hero_lvl-1]);
						}else if(hero_ability == 2) {
							array_skills();
							System.out.println("\n\tYou unlocked a new skill! ");
							try {
								Thread.sleep(2000);
							}catch(Exception e) {
								System.out.println(e);
							}
							System.out.println("\t>> " + warrior_skills[hero_lvl-1]);

						}else if(hero_ability == 3) {
							array_skills();
							System.out.println("\n\tYou unlocked a new skill! ");
							try {
								Thread.sleep(2000);
							}catch(Exception e) {
								System.out.println(e);
							}
							System.out.println("\t>> " + orc_skills[hero_lvl-1]);

						}
					}
				}
					System.out.println();
					try {
						for(int i=1;i<=6;i++) {
							Thread.sleep(100);
							System.out.print("\t");

							System.out.print(">>");
						}
					}catch(Exception e) {
						System.out.println(e);
					}
					System.out.println();
					
					System.out.println("\n\tYour remaining hp: "+ hero_maxHealth);
					total_hmp = (hero_mp <1)?0:hero_mp; //TERNARY OPERATOR!!!!!!!
					System.out.println("\tYour remaining mp: "+ total_hmp);
					System.out.println("\tYour hero level: " + hero_lvl);
					
//					if(exp >= hero_lvl * 100) {
//						
//						
//					}
					System.out.println("\n\tDo you want to explore again? (Y/N): ");
					String explore = in.nextLine();
					if(explore.equalsIgnoreCase("Y")) {
						System.out.println("\n\tContinuing journey... ");
						try {
							
							Thread.sleep(2000);
							
						}catch(Exception e) {
							
							System.out.println(e);
							
						}
						
						continue START;
					}else {
						set_heroExp(1);
						set_heroLvl(1);
						set_mage(60,80,75,150);
						set_warrior(80, 60, 85, 50);
						set_orc(70, 65, 150, 60);
						System.out.println("\tReturning to main menu...");
						try {
							
							Thread.sleep(2000);
							
						}catch(Exception e) {
							
							System.out.println(e);
							
						}
						
						continue OPTION;
						
					}
				}
				
			 }//loop while enemy health > 0	

				
				}//loop while running
				
			}else if(select == '2') {
				
				System.out.println("Quest(s): ");
				System.out.println("\n>The executioner.\nQuest mission: Beat 3 enemies. ");
				System.out.println("\n>Monster Hunter. \n Quest mission: Defeat any monsters you encounter.");
				continue OPTION;
				
			}else if(select == '3') {
				
				System.out.println("Thank you for playing!");
				
				System.exit(0);
				
			}
			
			}while(select != 1 && select != 2);
			
				System.out.println("You are low on health!\nGame over!");
				System.exit(0);
			
		}
		
		public void greet_user() {
			System.out.println("\n\n\t_________________________________________________________________________");
			System.out.println("\n\tWelcome to Hero Conquest "+ this.hero_name + " what woud you like to do:\n " );
			try {
				Thread.sleep(1000);
			}catch(Exception e) {
				System.out.println(e);
				
			}
			System.out.println("\t[1] Battle");

			try {
				Thread.sleep(1000);
			}catch(Exception e) {
				System.out.println(e);
			}
			System.out.println("\t[2] View Quest");

			try {
				Thread.sleep(1000);
			}catch(Exception e) {
				System.out.println(e);
			}
			System.out.println("\t[3] Quit");

			System.out.println("\t_________________________________________________________________________");
			
		}
			
		
		public void hero_attack() {
			
			System.out.println("\n\t" + hero_name + " chose to attack the enemy.");
			int maxHero_ad = hero_attackDmg;
			int minHero_ad = hero_attackDmg / 2;
			int rangeHero_ad = maxHero_ad - minHero_ad + 1;
			int totalHero_ad = (int)(Math.random() * rangeHero_ad) + minHero_ad;
			int damage_dealt = totalHero_ad;
			int attack = rand.nextInt(100);
			
			System.out.println("\n\t*Attacking the enemy*\n");
			try {
				
				Thread.sleep(3000);
				
			}catch(Exception e) {
				
				System.out.println(e);
				
			}
			try {
				for(int i=1;i<=6;i++) {
					Thread.sleep(100);
					System.out.print("\t");

					System.out.print(">>");
				}
			}catch(Exception e) {
				System.out.println(e);
			}
			
			System.out.println();
			if(attack > missChance){
				damage_dealt = 0;							//generate miss attack		
				System.out.println("\n\tYou missed!");
			}else {
			this.enemy_hp -= damage_dealt;
			}
			System.out.println("\n\tYou've dealt " + damage_dealt + " to the enemy!");
			int total_enemyHP = 0;
			if(enemy_hp < 1) {
				System.out.println("\t" + enemy + " remaining HP: " + total_enemyHP);
				System.out.println("\n\t" + "You've defeated an enemy! ");
			}else if(enemy_hp >= 1) {
			System.out.println("\t" + enemy + " remaining HP: " + enemy_hp);

			}
		}
		
		//abilities
		public void mage_abilities() {
			
			System.out.println("\tAbilities: \n");
			ArrayList<String> mage = new ArrayList<String>();
			if(hero_exp >= 0 && hero_exp <= 99) {
				
				mage.add("\t[a] Frost bite  (mp cost: 35)");
			}else if(hero_exp >= 100 && hero_exp <= 199) {
				mage.add("\t[a] Frost bite  (mp cost: 35)");
				mage.add("\t[b] Crescent flare  (mp cost: 50)");
			}else if(hero_exp >= 200 && hero_exp <= 299) {
				mage.add("\t[a] Frost bite  (mp cost: 35)");
				mage.add("\t[b] Crescent flare  (mp cost: 50)");
				mage.add("\t[c] Thunder reign  (mp cost: 70)");
			}else if(hero_exp >= 300 && hero_exp <= 399) {
				mage.add("\t[a] Frost bite  (mp cost: 35)");
				mage.add("\t[b] Crescent flare  (mp cost: 50)");
				mage.add("\t[c] Thunder reign  (mp cost: 70)");
				mage.add("\t[d] Howl\t mp cost: 85  (mp cost: 85)");
			}else if(hero_exp >= 400 && hero_exp <= 500) {
				mage.add("\t[a] Frost bite  (mp cost: 35)");
				mage.add("\t[b] Crescent flare  (mp cost: 50)");
				mage.add("\t[c] Thunder reign  (mp cost: 70)");
				mage.add("\t[d] Howl\t (mp cost: 85)");
				mage.add("\t[e] White apocalypse  (mp cost: 100)");
			}else if(hero_exp > 500) {
				mage.add("\t[a] Frost bite  (mp cost: 35)");
				mage.add("\t[b] Crescent flare  (mp cost: 50)");
				mage.add("\t[c] Thunder reign  (mp cost: 70)");
				mage.add("\t[d] Howl  (mp cost: 85)");
				mage.add("\t[e] White apocalypse  (mp cost: 100)");
			}
			for(String a : mage) {
				System.out.println(a+"\n");
			}
	 	}
		public void warrior_abilities() {
			System.out.println("Abilities: ");
			ArrayList<String> warrior = new ArrayList<String>();
			if(hero_exp >= 0 && hero_exp <= 99) {
				warrior.add("[a] Slice & Dice");
			}else if(hero_exp >= 100 && hero_exp <= 199) {
				hero_lvl++;
				warrior.add("[a] Slice & Dice");
				warrior.add("[b] Blade spin");
			}else if(hero_exp >= 200 && hero_exp <= 299) {
				warrior.add("[a] Slice & Dice");
				warrior.add("[b] Blade spin");
				warrior.add("[c] Soaring vortex");
			}else if(hero_exp >= 300 && hero_exp <= 399) {
				warrior.add("[a] Slice & Dice");
				warrior.add("[b] Blade spin");
				warrior.add("[c] Soaring vortex");
				warrior.add("[d] Ethereal blade");
			}else if(hero_exp >= 400 && hero_exp <= 500) {
				warrior.add("[a] Slice & Dice");
				warrior.add("[b] Blade spin");
				warrior.add("[c] Soaring vortex");
				warrior.add("[d] Ethereal blade");
				warrior.add("[e] Dimension slash");
			}else if(hero_exp > 500) {
				warrior.add("[a] Slice & Dice");
				warrior.add("[b] Blade spin");
				warrior.add("[c] Soaring vortex");
				warrior.add("[d] Ethereal blade");
				warrior.add("[e] Dimension slash");
			}
				for(String a : warrior) {
					System.out.println(a+"\n");
				}
		}
		public void orc_abilities() {
			System.out.println("Abilities: ");
			ArrayList<String> orc = new ArrayList<String>();
			if(hero_exp >= 0 && hero_exp <= 99) {
				orc.add("[a] Berserk");
			}else if(hero_exp >= 100 && hero_exp <= 199) {
				orc.add("[a] Berserk");
				orc.add("[b] Fatal end");
			}else if(hero_exp >= 200 && hero_exp <= 299) {
				orc.add("[a] Berserk");
				orc.add("[b] Fatal end");
				orc.add("[c] Myriad blade");
			}else if(hero_exp >= 300 && hero_exp <= 399) {
				orc.add("[a] Berserk");
				orc.add("[b] Fatal end");
				orc.add("[c] Myriad blade");
				orc.add("[d] Counterstrike");
			}else if(hero_exp >= 400 && hero_exp <= 500) {
				orc.add("[a] Berserk");
				orc.add("[b] Fatal end");
				orc.add("[c] Myriad blade");
				orc.add("[d] Counterstrike");
				orc.add("[e] Agnerastriya");
			}else if(hero_exp > 500) {
				orc.add("[a] Berserk");
				orc.add("[b] Fatal end");
				orc.add("[c] Myriad blade");
				orc.add("[d] Counterstrike");
				orc.add("[e] Agnerastriya");
			}
				for(String a : orc) {
					System.out.println(a+"\n");
				}
		}
		
		//ability miss chance
		public void ability_missChance(int miss) {
			
			int magic_attack = rand.nextInt(100);
			
			if(magic_attack > missChance) {
																//wrong!!!!!!!!!!!!!!
				hero_magicDmg = 0;
				System.out.println("\n\tYou missed!");
			}
			
		}
		
		
		
		//ability damage (MAGE)
		public void frost_bite() {
			int max_magicDmg = this.hero_magicDmg;
			int min_magicDmg = this.hero_magicDmg / 2;
			int range_magicDmg = max_magicDmg - min_magicDmg + 1;
			int total_magicDmg = (int)(Math.random() * range_magicDmg) + min_magicDmg;
			this.enemy_hp -= total_magicDmg;
			
			System.out.println("\t"+hero_name + " uses Frost bite!\n");
			
			try {
				
				Thread.sleep(3000);
				
			}catch(Exception e) {
				
				System.out.println(e);
				
			}
			try {
				for(int i=1;i<=6;i++) {
					Thread.sleep(100);
					System.out.print("\t");

					System.out.print(">>");
				}
			}catch(Exception e) {
				System.out.println(e);
			}
			
			System.out.println("\n");
			
			missChance = 90;
			ability_missChance(missChance); 
			System.out.println("\t"+hero_name + " dealt " + total_magicDmg + " damage points to the enemy");
			int total_enemyHP = 0;
			if(enemy_hp < 1) {
				System.out.println("\n\t"+enemy + " remaining HP: " + total_enemyHP);
			}else if(enemy_hp >= 1) {
			System.out.println("\n\t"+enemy + " remaining HP: " + enemy_hp);
			}
			if(enemy_hp < 1) {
				
				System.out.println("\n\t"+"You've defeated an enemy! ");
				
			}
		
			
			
		}
		
		
		public void crescent_flare() {
			int max_magicDmg = this.hero_magicDmg + (hero_lvl * 2);
			int min_magicDmg = this.hero_magicDmg / 2;
			int range_magicDmg = max_magicDmg - min_magicDmg + 1;
			int total_magicDmg = (int)(Math.random() * range_magicDmg) + min_magicDmg;
			this.enemy_hp -= total_magicDmg;
			
			System.out.println("\t"+hero_name + " uses Crescent flare!\n");
			
	try {
				
				Thread.sleep(3000);
				
			}catch(Exception e) {
				
				System.out.println(e);
				
			}
			try {
				for(int i=1;i<=6;i++) {
					Thread.sleep(100);
					System.out.print("\t");

					System.out.print(">>");
				}
			}catch(Exception e) {
				System.out.println(e);
			}
			
			System.out.println("\n");
			missChance = 88;
			ability_missChance(missChance); 
			System.out.println("\t"+hero_name + " dealt " + total_magicDmg + " damage points to the enemy");
			int total_enemyHP = 0;
			if(enemy_hp < 1) {
				System.out.println("\n\t"+enemy + " remaining HP: " + total_enemyHP);
			}else if(enemy_hp >= 1) {
			System.out.println("\n\t"+enemy + " remaining HP: " + enemy_hp);
			}
			if(enemy_hp < 1) {
				
				System.out.println("\n\t"+"You've defeated an enemy! ");
				
			}
			
		}

		
		public void thunder_reign() {
			int max_magicDmg = this.hero_magicDmg + (hero_lvl * 2);
			int min_magicDmg = this.hero_magicDmg / 2;
			int range_magicDmg = max_magicDmg - min_magicDmg + 1;
			int total_magicDmg = (int)(Math.random() * range_magicDmg) + min_magicDmg;
			this.enemy_hp -= total_magicDmg;
			
			System.out.println("\t"+hero_name + " uses Thunder reign!\n");
	try {
				
				Thread.sleep(3000);
				
			}catch(Exception e) {
				
				System.out.println(e);
				
			}
			try {
				for(int i=1;i<=6;i++) {
					Thread.sleep(100);
					System.out.print("\t");

					System.out.print(">>");
				}
			}catch(Exception e) {
				System.out.println(e);
			}
			
			System.out.println("\n");
			missChance = 95;
			ability_missChance(missChance); 
			System.out.println("\t"+hero_name + " dealt " + total_magicDmg + " damage points to the enemy");
			int total_enemyHP = 0;
			if(enemy_hp < 1) {
				System.out.println("\n\t"+enemy + " remaining HP: " + total_enemyHP);
			}else if(enemy_hp >= 1) {
			System.out.println("\n\t"+enemy + " remaining HP: " + enemy_hp);
			}
			if(enemy_hp < 1) {
				
				System.out.println("\n\tYou've defeated an enemy! ");
				
			}
			
		}
		
		public void howl() {
			int max_magicDmg = this.hero_magicDmg + (hero_lvl * 2);
			int min_magicDmg = this.hero_magicDmg / 2;
			int range_magicDmg = max_magicDmg - min_magicDmg + 1;
			int total_magicDmg = (int)(Math.random() * range_magicDmg) + min_magicDmg;
			this.enemy_hp -= total_magicDmg;
			
			System.out.println("\t"+hero_name + " uses Howl!\n");
	try {
				
				Thread.sleep(3000);
				
			}catch(Exception e) {
				
				System.out.println(e);
				
			}
			try {
				for(int i=1;i<=6;i++) {
					Thread.sleep(100);
					System.out.print("\t");

					System.out.print(">>");
				}
			}catch(Exception e) {
				System.out.println(e);
			}
			
			System.out.println("\n");
			missChance = 86;
			ability_missChance(missChance); 
			System.out.println("\t"+hero_name + " dealt " + total_magicDmg + " damage points to the enemy");
			int total_enemyHP = 0;
			if(enemy_hp < 1) {
				System.out.println("\n\t"+enemy + " remaining HP: " + total_enemyHP);
			}else if(enemy_hp >= 1) {
			System.out.println("\n\t"+enemy + " remaining HP: " + enemy_hp);
			}
			if(enemy_hp < 1) {
				
				System.out.println("\n\tYou've defeated an enemy! ");
				
			}
			
		}
		
		public void white_apocalypse() {
			int max_magicDmg = this.hero_magicDmg + (hero_lvl * 2);
			int min_magicDmg = this.hero_magicDmg / 2;
			int range_magicDmg = max_magicDmg - min_magicDmg + 1;
			int total_magicDmg = (int)(Math.random() * range_magicDmg) + min_magicDmg;
			this.enemy_hp -= total_magicDmg;
			
			System.out.println("\n\t"+hero_name + " uses White apocalypse!\n");
	try {
				
				Thread.sleep(3000);
				
			}catch(Exception e) {
				
				System.out.println(e);
				
			}
			try {
				for(int i=1;i<=6;i++) {
					Thread.sleep(100);
					System.out.print("\t");

					System.out.print(">>");
				}
			}catch(Exception e) {
				System.out.println(e);
			}
			
			System.out.println("\n");
			missChance = 99;
			ability_missChance(missChance); 
			System.out.println("\t"+hero_name + " dealt " + total_magicDmg + " damage points to the enemy");
			int total_enemyHP = 0;
			if(enemy_hp < 1) {
				System.out.println("\n\t"+enemy + " remaining HP: " + total_enemyHP);
			}else if(enemy_hp >= 1) {
			System.out.println("\n\t"+enemy + " remaining HP: " + enemy_hp);
			}
			if(enemy_hp < 1) {
				
				System.out.println("\n\tYou've defeated an enemy! ");
				
			}
			
		}

		
		
		public void slice_dice() {
			
			int max_attackDmg = this.hero_attackDmg + (hero_lvl * 2);
			int min_attackDmg = this.hero_attackDmg / 2;
			int range_attackDmg = max_attackDmg - min_attackDmg + 1;
			int total_attackDmg = (int)(Math.random() * range_attackDmg) + min_attackDmg;
			this.enemy_hp -= total_attackDmg;
			System.out.println("\t"+hero_name + " uses Slice & Dice!");
	try {
				
				Thread.sleep(3000);
				
			}catch(Exception e) {
				
				System.out.println(e);
				
			}
			try {
				for(int i=1;i<=6;i++) {
					Thread.sleep(100);
					System.out.print("\t");

					System.out.print(">>");
				}
			}catch(Exception e) {
				System.out.println(e);
			}
			
			System.out.println("\n");
			missChance = 90;
			ability_missChance(missChance);
			System.out.println("\t"+hero_name + " dealt " + total_attackDmg + " damage points to the enemy");
			int total_enemyHP = 0;
			if(enemy_hp < 1) {
				System.out.println("\n\t"+enemy + " remaining HP: " + total_enemyHP);
			}else if(enemy_hp >= 1) {
			System.out.println("\n\t"+enemy + " remaining HP: " + enemy_hp);
			}
			if(enemy_hp < 1) {
				
				System.out.println("\n\tYou've defeated an enemy! ");
				
			}
			
			
		}
		
		public void blade_spin() {
			
			int max_attackDmg = this.hero_attackDmg + (hero_lvl * 2);
			int min_attackDmg = this.hero_attackDmg / 2;
			int range_attackDmg = max_attackDmg - min_attackDmg + 1;
			int total_attackDmg = (int)(Math.random() * range_attackDmg) + min_attackDmg;
			this.enemy_hp -= total_attackDmg;
			missChance = 90;
			System.out.println("\t"+hero_name + " uses Blade spin!");
	try {
				
				Thread.sleep(3000);
				
			}catch(Exception e) {
				
				System.out.println(e);
				
			}
			try {
				for(int i=1;i<=6;i++) {
					Thread.sleep(100);
					System.out.print("\t");

					System.out.print(">>");
				}
			}catch(Exception e) {
				System.out.println(e);
			}
			
			System.out.println("\n");
			ability_missChance(missChance);
			System.out.println("\t"+hero_name + " dealt " + total_attackDmg + " damage points to the enemy");
			int total_enemyHP = 0;
			if(enemy_hp < 1) {
				System.out.println("\n\t"+enemy + " remaining HP: " + total_enemyHP);
			}else if(enemy_hp >= 1) {
			System.out.println("\n\t"+enemy + " remaining HP: " + enemy_hp);
			}
			if(enemy_hp < 1) {
				
				System.out.println("\n\tYou've defeated an enemy! ");
				
			}
			
			
		}
		
		public void soaring_vortex() {
			
			int max_attackDmg = this.hero_attackDmg + (hero_lvl * 2);
			int min_attackDmg = this.hero_attackDmg / 2;
			int range_attackDmg = max_attackDmg - min_attackDmg + 1;
			int total_attackDmg = (int)(Math.random() * range_attackDmg) + min_attackDmg;
			this.enemy_hp -= total_attackDmg;
			System.out.println("\t"+hero_name + " uses Soaring vortex!");
	try {
				
				Thread.sleep(3000);
				
			}catch(Exception e) {
				
				System.out.println(e);
				
			}
			try {
				for(int i=1;i<=6;i++) {
					Thread.sleep(100);
					System.out.print("\t");

					System.out.print(">>");
				}
			}catch(Exception e) {
				System.out.println(e);
			}
			
			System.out.println("\n");
			missChance = 90;
			ability_missChance(missChance);
			System.out.println("\t"+hero_name + " dealt " + total_attackDmg + " damage points to the enemy");
			int total_enemyHP = 0;
			if(enemy_hp < 1) {
				System.out.println("\n\t"+enemy + " remaining HP: " + total_enemyHP);
			}else if(enemy_hp >= 1) {
			System.out.println("\n\t"+enemy + " remaining HP: " + enemy_hp);
			}
			if(enemy_hp < 1) {
				
				System.out.println("\n\tYou've defeated an enemy! ");
				
			}
			
			
		}
		
		public void ethereal_blade() {
			
			int max_attackDmg = this.hero_attackDmg + (hero_lvl * 2);
			int min_attackDmg = this.hero_attackDmg / 2;
			int range_attackDmg = max_attackDmg - min_attackDmg + 1;
			int total_attackDmg = (int)(Math.random() * range_attackDmg) + min_attackDmg;
			this.enemy_hp -= total_attackDmg;
			System.out.println("\t"+hero_name + " uses Ethereal blade!");
	try {
				
				Thread.sleep(3000);
				
			}catch(Exception e) {
				
				System.out.println(e);
				
			}
			try {
				for(int i=1;i<=6;i++) {
					Thread.sleep(100);
					System.out.print("\t");

					System.out.print(">>");
				}
			}catch(Exception e) {
				System.out.println(e);
			}
			
			System.out.println("\n");
			missChance = 90;
			ability_missChance(missChance);
			System.out.println("\t"+hero_name + " dealt " + total_attackDmg + " damage points to the enemy");
			int total_enemyHP = 0;
			if(enemy_hp < 1) {
				System.out.println("\n\t"+enemy + " remaining HP: " + total_enemyHP);
			}else if(enemy_hp >= 1) {
			System.out.println("\n\t"+enemy + " remaining HP: " + enemy_hp);
			}
			if(enemy_hp < 1) {
				
				System.out.println("\n\tYou've defeated an enemy! ");
				
			}
			
			
		}
		
		public void dimension_slash() {
			
			int max_attackDmg = this.hero_attackDmg + (hero_lvl * 2);
			int min_attackDmg = this.hero_attackDmg / 2;
			int range_attackDmg = max_attackDmg - min_attackDmg + 1;
			int total_attackDmg = (int)(Math.random() * range_attackDmg) + min_attackDmg;
			this.enemy_hp -= total_attackDmg;
			System.out.println("\t"+hero_name + " uses Dimension slash!");
	try {
				
				Thread.sleep(3000);
				
			}catch(Exception e) {
				
				System.out.println(e);
				
			}
			try {
				for(int i=1;i<=6;i++) {
					Thread.sleep(100);
					System.out.print("\t");

					System.out.print(">>");
				}
			}catch(Exception e) {
				System.out.println(e);
			}
			
			System.out.println("\n");
			missChance = 90;
			ability_missChance(missChance);
			System.out.println("\t"+hero_name + " dealt " + total_attackDmg + " damage points to the enemy");
			int total_enemyHP = 0;
			if(enemy_hp < 1) {
				System.out.println("\n\t"+enemy + " remaining HP: " + total_enemyHP);
			}else if(enemy_hp >= 1) {
			System.out.println("\n\t"+enemy + " remaining HP: " + enemy_hp);
			}
			if(enemy_hp < 1) {
				
				System.out.println("\n\tYou've defeated an enemy! ");
				
			}
			
			
		}
		
		public void berserk() {
			
			int max_attackDmg = this.hero_attackDmg + (hero_lvl * 2);
			int min_attackDmg = this.hero_attackDmg / 2;
			int range_attackDmg = max_attackDmg - min_attackDmg + 1;
			int total_attackDmg = (int)(Math.random() * range_attackDmg) + min_attackDmg;
			this.enemy_hp -= total_attackDmg;
			System.out.println("\t"+hero_name + " uses Berserk!");
	try {
				
				Thread.sleep(3000);
				
			}catch(Exception e) {
				
				System.out.println(e);
				
			}
			try {
				for(int i=1;i<=6;i++) {
					Thread.sleep(100);
					System.out.print("\t");

					System.out.print(">>");
				}
			}catch(Exception e) {
				System.out.println(e);
			}
			
			System.out.println("\n");		
			missChance = 90;
			ability_missChance(missChance);
			System.out.println("\t"+hero_name + " dealt " + total_attackDmg + " damage points to the enemy");
			int total_enemyHP = 0;
			if(enemy_hp < 1) {
				System.out.println("\n\t"+enemy + " remaining HP: " + total_enemyHP);
			}else if(enemy_hp >= 1) {
			System.out.println("\n\t"+enemy + " remaining HP: " + enemy_hp);
			}
			if(enemy_hp < 1) {
				
				System.out.println("\n\tYou've defeated an enemy! ");
				
			}
			
			
		}
		
		public void fatal_end() {
			
			int max_attackDmg = this.hero_attackDmg + (hero_lvl * 2);
			int min_attackDmg = this.hero_attackDmg / 2;
			int range_attackDmg = max_attackDmg - min_attackDmg + 1;
			int total_attackDmg = (int)(Math.random() * range_attackDmg) + min_attackDmg;
			this.enemy_hp -= total_attackDmg;
			System.out.println("\t"+hero_name + " uses Fatal end!");
	try {
				
				Thread.sleep(3000);
				
			}catch(Exception e) {
				
				System.out.println(e);
				
			}
			try {
				for(int i=1;i<=6;i++) {
					Thread.sleep(100);
					System.out.print("\t");

					System.out.print(">>");
				}
			}catch(Exception e) {
				System.out.println(e);
			}
			
			System.out.println("\n");
			missChance = 90;
			ability_missChance(missChance);
			System.out.println("\t"+hero_name + " dealt " + total_attackDmg + " damage points to the enemy");
			int total_enemyHP = 0;
			if(enemy_hp < 1) {
				System.out.println("\n\t"+enemy + " remaining HP: " + total_enemyHP);
			}else if(enemy_hp >= 1) {
			System.out.println("\n\t"+enemy + " remaining HP: " + enemy_hp);
			}
			if(enemy_hp < 1) {
				
				System.out.println("\n\tYou've defeated an enemy! ");
				
			}
			
			
		}
		
		public void myriad_blades() {
			
			int max_attackDmg = this.hero_attackDmg + (hero_lvl * 2);
			int min_attackDmg = this.hero_attackDmg / 2;
			int range_attackDmg = max_attackDmg - min_attackDmg + 1;
			int total_attackDmg = (int)(Math.random() * range_attackDmg) + min_attackDmg;
			this.enemy_hp -= total_attackDmg;
			System.out.println("\t"+hero_name + " uses Myriad blades!");
	try {
				
				Thread.sleep(3000);
				
			}catch(Exception e) {
				
				System.out.println(e);
				
			}
			try {
				for(int i=1;i<=6;i++) {
					Thread.sleep(100);
					System.out.print("\t");

					System.out.print(">>");
				}
			}catch(Exception e) {
				System.out.println(e);
			}
			
			System.out.println("\n");
			missChance = 90;
			ability_missChance(missChance);
			System.out.println("\t"+hero_name + " dealt " + total_attackDmg + " damage points to the enemy");
			int total_enemyHP = 0;
			if(enemy_hp < 1) {
				System.out.println("\n\t"+enemy + " remaining HP: " + total_enemyHP);
			}else if(enemy_hp >= 1) {
			System.out.println("\n\t"+enemy + " remaining HP: " + enemy_hp);
			}
			if(enemy_hp < 1) {
				
				System.out.println("\n\tYou've defeated an enemy! ");
				
			}
			
			
		}
		
		public void counter_strike() {
			
			int max_attackDmg = this.hero_attackDmg + (hero_lvl * 2);
			int min_attackDmg = this.hero_attackDmg / 2;
			int range_attackDmg = max_attackDmg - min_attackDmg + 1;
			int total_attackDmg = (int)(Math.random() * range_attackDmg) + min_attackDmg;
			this.enemy_hp -= total_attackDmg;
			System.out.println("\t"+hero_name + " uses Counter strike!");
	try {
				
				Thread.sleep(3000);
				
			}catch(Exception e) {
				
				System.out.println(e);
				
			}
			try {
				for(int i=1;i<=6;i++) {
					Thread.sleep(100);
					System.out.print("\t");

					System.out.print(">>");
				}
			}catch(Exception e) {
				System.out.println(e);
			}
			
			System.out.println("\n");
			missChance = 90;
			ability_missChance(missChance);
			System.out.println("\t"+hero_name + " dealt " + total_attackDmg + " damage points to the enemy");
			int total_enemyHP = 0;
			if(enemy_hp < 1) {
				System.out.println("\n\t"+enemy + " remaining HP: " + total_enemyHP);
			}else if(enemy_hp >= 1) {
			System.out.println("\n\t"+enemy + " remaining HP: " + enemy_hp);
			}
			if(enemy_hp < 1) {
				
				System.out.println("\n\tYou've defeated an enemy! ");
				
			}
			
			
		}
		
		public void agnerastriya() {
			
			int max_attackDmg = this.hero_attackDmg + (hero_lvl * 2);
			int min_attackDmg = this.hero_attackDmg / 2;
			int range_attackDmg = max_attackDmg - min_attackDmg + 1;
			int total_attackDmg = (int)(Math.random() * range_attackDmg) + min_attackDmg;
			this.enemy_hp -= total_attackDmg;
			System.out.println("\t"+hero_name + " uses Agnerastriya!");
	try {
				
				Thread.sleep(3000);
				
			}catch(Exception e) {
				
				System.out.println(e);
				
			}
			try {
				for(int i=1;i<=6;i++) {
					Thread.sleep(100);
					System.out.print("\t");

					System.out.print(">>");
				}
			}catch(Exception e) {
				System.out.println(e);
			}
			
			System.out.println("\n");
			missChance = 90;
			ability_missChance(missChance);
			System.out.println("\t"+hero_name + " dealt " + total_attackDmg + " damage points to the enemy");
			int total_enemyHP = 0;
			if(enemy_hp < 1) {
				System.out.println("\n\t"+enemy + " remaining HP: " + total_enemyHP);
			}else if(enemy_hp >= 1) {
			System.out.println("\n\t"+enemy + " remaining HP: " + enemy_hp);
			}
			if(enemy_hp < 1) {
				
				System.out.println("\n\tYou've defeated an enemy! ");
				
			}
			
			
		}
		
		public void set_heroExp(int exp) {
			
			hero_exp = exp;
			
		}
		
		public void set_heroLvl(int lvl) {
			
			hero_lvl = lvl;
			
		}

		
		//HERO BASE STATS
		private void set_mage(int ad, int md, int hp, int mp) {
			
			this.hero_attackDmg = ad;
			this.hero_magicDmg = md;					//stat for mage
			this.hero_maxHealth = hp;
			this.hero_mp = mp;
			
		}
		
		private void set_warrior(int ad, int md, int hp, int mp) {
			
			this.hero_attackDmg = ad;
			this.hero_magicDmg = md;					//stat for warrior
			this.hero_maxHealth = hp;
			this.hero_mp = mp;
			
		}
		private void set_orc(int ad, int md, int hp, int mp) {
			
			this.hero_attackDmg = ad;
			this.hero_magicDmg = md;					//stat for orc
			this.hero_maxHealth = hp;
			this.hero_mp = mp;
			
		}
		
		private void select_hero() {
			try {
				
				Thread.sleep(2000);
				
			}catch(Exception e) {
				
				System.out.println(e);
				
			}
			System.out.println("\n\t_________________________________________________________________________\n");
			System.out.println("\tChoose your desired character role:\n ");
			try {
				Thread.sleep(500);
			}catch(Exception e) {
				System.out.println(e);
			}
			System.out.println("\t[1] Mage");
			try {
				Thread.sleep(500);
			}catch(Exception e) {
				System.out.println(e);
			}
			System.out.println("\t[2] Warrior");
			try {
				Thread.sleep(500);
			}catch(Exception e) {
				System.out.println(e);
			}
			System.out.println("\t[3] Orc");
			System.out.println("\t_________________________________________________________________________");

			char choice;
			
			boolean access = true;
			do {
			choice = in.next().charAt(0);
			try {
				if(choice == '1') {
				
					set_mage(60,80,75,150);		//ad,md,hp,mp
					hero_ab(1);
					access = false;
					
				}else if(choice == '2') {
					
					set_warrior(80, 60, 85, 50);	//ad,md,hp,mp
					hero_ab(2);
					access = false;
					
				}else if(choice == '3') {
					
					set_orc(70, 65, 150, 60);	//ad,md,hp,mp
					hero_ab(3);
					access = false;
					
				}else {
					
					System.out.println("Invalid input!");
					
				}
			}catch(Exception e) {
				System.err.println("Invalid input!");
			}
			}while(access != false);
			
			
		}
		
		public static void view_quest() {
			
			System.out.println("\n>The executioner.\nQuest description: Beat 3 enemies. ");
			
		}
		
		
		//ENEMY STATS
		
		public void enemy_stats(int ad, int ap, int mp) {
			//"Zombie","Assassin","Troll","Goblin","Serpent","Giant Sting Bee","Warlord"
			
			this.enemy_attackDmg = ad;
			this.enemy_magicDmg = ap;
			this.enemy_mp = mp;
		}
		
		public void set_enemyStats() {
			
			if(enemy.contentEquals("Zombie")) {
				
				enemy_stats(10,10, e_mp());
				
			}else if(enemy.contentEquals("Assassin")) {
				
				enemy_stats(20,20, e_mp());
				
			}else if(enemy.contentEquals("Troll")) {
				
				enemy_stats(25,30, e_mp());
				
			}else if(enemy.contentEquals("Goblin")) {
				
				enemy_stats(20,30, e_mp());
				
			}else if(enemy.contentEquals("Serpent")) {
				
				enemy_stats(30,30, e_mp());
				
			}else if(enemy.contentEquals("Giant Sting Bee")) {
				
				enemy_stats(20,30, e_mp());
				
			}else if(enemy.contentEquals("Warlord")) {
				
				enemy_stats(30,40, e_mp());
				
			}
			
			try {
				
				Thread.sleep(2000);
				
			}catch(Exception e) {
				
				System.out.println(e);
				
			}
			
		}
		
		
		public void enemy_skills() {
			
			//chance
			
				if(enemy.contentEquals("Zombie")) {
					try {
						
						Thread.sleep(3000);
						
					}catch(Exception e) {
						
						System.out.println(e);
						
					}
					this.enemy_skillCost = 20;
					System.out.println("\n\tThe "+ enemy + " used an ability!");
					System.out.println("\t>>Infectious bite<<");
					
					int max = enemy_magicDmg;
					int min = enemy_magicDmg/2;
					int range = max - min + 1;
					totalDmg = (int)(Math.random()* range) + min;
					hero_maxHealth -= totalDmg;
					try {
						Thread.sleep(1000);
					}catch(Exception e) {
						System.out.println(e);
					}
					System.out.println("\n\tYou received "+ totalDmg + " damage points!");
					System.out.println("\t" + enemy + " remaining MP: " + enemy_mp);

					
				}else if(enemy.contentEquals("Assassin")) {
					try {
						
						Thread.sleep(3000);
						
					}catch(Exception e) {
						
						System.out.println(e);
						
					}
					this.enemy_skillCost = 30;
					enemy_mp -= enemy_skillCost;
					
					System.out.println("\n\tThe "+ enemy + " used an ability!");
					System.out.println("\t>>Blade cult<<");
					int max = enemy_magicDmg;
					int min = enemy_magicDmg/2;
					int range = max - min + 1;
					totalDmg = (int)(Math.random()* range) + min;
					hero_maxHealth -= totalDmg;		
					try {
						Thread.sleep(1000);
					}catch(Exception e) {
						System.out.println(e);
					}
					System.out.println("\n\tYou received "+ totalDmg + " damage points!");
					System.out.println("\t" + enemy + " remaining MP: " + enemy_mp);
					
				}else if(enemy.contentEquals("Troll")) {
					try {
						
						Thread.sleep(3000);
						
					}catch(Exception e) {
						
						System.out.println(e);
						
					}
					this.enemy_skillCost = 30;
					enemy_mp -= enemy_skillCost;
					System.out.println("\n\tThe "+ enemy + " used an ability!");
					System.out.println("\t>>Earth shaker<<");

					int max = enemy_magicDmg;
					int min = enemy_magicDmg/2;
					int range = max - min + 1;
					totalDmg = (int)(Math.random()* range) + min;
					hero_maxHealth -= totalDmg;	
					try {
						Thread.sleep(1000);
					}catch(Exception e) {
						System.out.println(e);
					}
					System.out.println("\n\tYou received "+ totalDmg + " damage points!");
					System.out.println("\t" + enemy + " remaining MP: " + enemy_mp);

					
			    }else if(enemy.contentEquals("Goblin")) {
					try {
						
						Thread.sleep(3000);
						
					}catch(Exception e) {
						
						System.out.println(e);
						
					}
					this.enemy_skillCost = 30;

					System.out.println("\n\tThe "+ enemy + " used an ability!");
					System.out.println("\t>>Snap<<");
					enemy_mp -= enemy_skillCost;

					int max = enemy_magicDmg;
					int min = enemy_magicDmg/2;
					int range = max - min + 1;
					totalDmg = (int)(Math.random()* range) + min;
					hero_maxHealth -= totalDmg;	
					try {
						Thread.sleep(1000);
					}catch(Exception e) {
						System.out.println(e);
					}
					System.out.println("\n\tYou received "+ totalDmg + " damage points!");
					System.out.println("\t" + enemy + " remaining MP: " + enemy_mp);

					
			    }else if(enemy.contentEquals("Serpent")) {
					try {
						
						Thread.sleep(3000);
						
					}catch(Exception e) {
						
						System.out.println(e);
						
					}
					this.enemy_skillCost = 40;
					enemy_mp -= enemy_skillCost;

					System.out.println("\n\tThe "+ enemy + " used an ability!");
					System.out.println("\t>>Tsunami<<");

					int max = enemy_magicDmg;
					int min = enemy_magicDmg/2;
					int range = max - min + 1;
					totalDmg = (int)(Math.random()* range) + min;
					hero_maxHealth -= totalDmg;
					try {
						Thread.sleep(1000);
					}catch(Exception e) {
						System.out.println(e);
					}
					System.out.println("\n\tYou received "+ totalDmg + " damage points!");
					System.out.println("\t" + enemy + " remaining MP: " + enemy_mp);

					
			   }else if(enemy.contentEquals("Giant Sting Bee")) {
					try {
						
						Thread.sleep(3000);
						
					}catch(Exception e) {
						
						System.out.println(e);
						
					}
					this.enemy_skillCost = 40;
					enemy_mp -= enemy_skillCost;

					System.out.println("\n\tThe "+ enemy + " used an ability!");
					System.out.println("\t>>Poison stinger<<");

					int max = enemy_magicDmg;
					int min = enemy_magicDmg/2;
					int range = max - min + 1;
					totalDmg = (int)(Math.random()* range) + min;
					hero_maxHealth -= totalDmg;
					try {
						Thread.sleep(1000);
					}catch(Exception e) {
						System.out.println(e);
					}
					System.out.println("\n\tYou received "+ totalDmg + " damage points!");
					System.out.println("\t" + enemy + " remaining MP: " + enemy_mp);

					
			  }else if(enemy.contentEquals("Warlord")) {
					try {
						
						Thread.sleep(3000);
						
					}catch(Exception e) {
						
						System.out.println(e);
						
					}
					this.enemy_skillCost = 50;
					enemy_mp -= enemy_skillCost;

					System.out.println("\n\tThe "+ enemy + " used an ability!");
					System.out.println("\t>>Wrath<<");

					int max = enemy_magicDmg;
					int min = enemy_magicDmg/2;
					int range = max - min + 1;
					totalDmg = (int)(Math.random()* range) + min;
					hero_maxHealth -= totalDmg;
					try {
						Thread.sleep(1000);
					}catch(Exception e) {
						System.out.println(e);
					}
					System.out.println("\n\tYou received "+ totalDmg + " damage points!");
					System.out.println("\t" + enemy + " remaining MP: " + enemy_mp);

			}			
		
			
			
	}
		
		public void enemy_attack() {
			
			try {
				Thread.sleep(700);
			}catch(Exception e) {
				System.out.println(e);
			}
			
			System.out.println("\tThe " + enemy + " is performing a direct attack!");
				try {
					
					Thread.sleep(3000);
					
				}catch(Exception e) {
					
					System.out.println(e);
					
				}
				
				int max = enemy_attackDmg;
				int min = enemy_attackDmg/2;
				int range = max - min + 1;
				totalDmg = (int)(Math.random()* range) + min;
				hero_maxHealth -= totalDmg;
				try {
					Thread.sleep(1000);
				}catch(Exception e) {
					System.out.println(e);
				}
				System.out.println("\n\tYou received "+ totalDmg + " damage points!");
			
		}
		
		
		
		public static int e_mp() {
			
			int max_mp = 80;
			int min_mp = 60;
			int range_mp = max_mp - min_mp + 1;
			int total_enemyMp = (int)(Math.random() * range_mp )+ min_mp;
			return total_enemyMp;
		}
		
		public void hero_ab(int choice) {
			
			this.hero_ability = choice;
			
			
		}
		
		public void enemy_turn() {
			
			try {
				Thread.sleep(700);
			}catch(Exception e) {
				System.out.println(e);
			}
			
			System.out.println("\n\t>> Enemy retaliation <<");
			
			int chance = rand.nextInt(100);

			if(enemy_skillChance < chance && enemy_mp >= enemy_skillCost) {
				
				enemy_skills();
				
				try {
					Thread.sleep(2000);
				}catch(Exception e) {
					System.out.println(e);
				}
				
			}else {
				
				
				enemy_attack();	
				try {
					Thread.sleep(2000);
				}catch(Exception e) {
					System.out.println(e);
				}
				
			}
			

			
			
		}
		
		public void array_skills() {
			
			mage_skills = new String[] {"Frost bite","Crescent flare","Thunder reign","Howl","White Apocalypse"};
			warrior_skills = new String[] {"Slice & Dice","Blade spin","Soaring vortex","Ethereal blade","Dimension slash"};
			orc_skills = new String[] {"Berserk","Fatal end","Myriad blade","Counterstrike","Agnerastriya"};

		}
		
		
	





	//HERO ABILITIES






	//
	//String[] username = {"mr.lynxions","jofs19","eaferrer0225"};
	//String[] password = {"june132001","persona4","ferrerfamily25"};

}
