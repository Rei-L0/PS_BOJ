import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {

	static int n, m, rx, ry, sx, sy, ex, ey, k, l;

	static final char WALL = '#';

	static String input;

	static Map<Character, Integer> dir = new HashMap<>();
	static Map<Pos, Monster> monster = new HashMap<>();
	static Map<Pos, Player> player = new HashMap<>();
	static Map<Pos, Box> item = new HashMap<>();

	static StringBuilder sb = new StringBuilder();

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	static char[][] map;

	static class Pos {

		int x;
		int y;

		@Override
		public boolean equals(Object o) {
			if (this == o) {
				return true;
			}
			if (o == null || getClass() != o.getClass()) {
				return false;
			}
			Pos pos = (Pos) o;
			return x == pos.x && y == pos.y;
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	static class Box {

		char type;
		int n;
		String s;

		public Box(char type, int n, String s) {
			this.type = type;
			this.n = n;
			this.s = s;
		}
	}

	static class Monster {

		int w;
		int a;
		int h;
		int e;
		String name;
		boolean isBoss;

		public Monster(int w, int a, int h, int e, String name) {
			this.w = w;
			this.a = a;
			this.h = h;
			this.e = e;
			this.name = name;
		}
	}

	static class Player {

		int h;
		int lv;
		int attack;
		int armor;
		int exp;
		int weapon;
		int guard;
		String[] acc;

		public Player() {
			this.h = 20;
			this.attack = 2;
			this.lv = 1;
			this.armor = 2;
			this.exp = 0;
			this.weapon = 0;
			this.guard = 0;
			this.acc = new String[4];
		}

		public Player(int h, int lv, int attack, int armor, int exp, int weapon, int guard, String[] acc) {
			this.h = h;
			this.lv = lv;
			this.attack = attack;
			this.armor = armor;
			this.exp = exp;
			this.weapon = weapon;
			this.guard = guard;
			this.acc = acc;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		dir.put('L', 0);
		dir.put('R', 1);
		dir.put('U', 2);
		dir.put('D', 3);

		map = new char[n + 1][m + 1];
		for (int i = 1; i < n + 1; i++) {
			String str = br.readLine();
			for (int j = 1; j < m + 1; j++) {
				map[i][j] = str.charAt(j - 1);
				if (map[i][j] == '@') {
					sx = i;
					sy = j;
					rx = i;
					ry = j;
				}
				if (map[i][j] == 'M') {
					ex = i;
					ey = j;
					k++;
				}
				if (map[i][j] == '&') {
					k++;
				}
				if (map[i][j] == 'B') {
					l++;
				}
			}
		}

		player.put(new Pos(sx, sy), new Player());

		input = br.readLine();

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			String s = st.nextToken();
			int w = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			monster.put(new Pos(x, y), new Monster(w, a, h, e, s));
		}

		for (int i = 0; i < l; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			char s = st.nextToken().charAt(0);
			if (s == 'O') {
				String name = st.nextToken();
				item.put(new Pos(x, y), new Box(s, 0, name));
			} else {
				int n = Integer.parseInt(st.nextToken());
				item.put(new Pos(x, y), new Box(s, n, ""));
			}
		}

		String ans = solve();

		// 입력이 끝났을 경우
		if (ans.equals("KILL")) {
			sb.append("YOU WIN!");
		} else if (ans.equals("END")) {
			sb.append("Press any key to continue.");
		} else {
			sb.append("YOU HAVE BEEN KILLED BY ").append(ans).append("..");
		}
		System.out.println(sb);
	}

	static String solve() {
		int idx = -1;
		map[sx][sy] = '.';
		while (idx != input.length() - 1) {
			idx++;
			Pos now = new Pos(sx, sy);
			Player play = player.get(now);
			int nx = sx + dx[dir.get(input.charAt(idx))];
			int ny = sy + dy[dir.get(input.charAt(idx))];
			if (nx < 1 || ny < 1 || nx > n || ny > m || map[nx][ny] == WALL) {
				// 가시에 찔려 죽을 때
				if (map[sx][sy] == '^') {
					int damage = 5;

					// 데미지 감소 보유 여부
					for (int i = 0; i < 4; i++) {
						if (play.acc[i] == null) {
							continue;
						}
						if (play.acc[i].equals("DX")) {
							damage = 1;
							break;
						}
					}
					play.h -= damage;
					// 죽었을 때
					if (play.h < 1) {
						boolean revive = false;
						// 부활 가능할 경우
						for (int i = 0; i < 4; i++) {
							if (play.acc[i] == null) {
								continue;
							}
							if (play.acc[i].equals("RE")) {
								reStart(now, play, i);
								revive = true;
								break;
							}
						}
						if (revive) {
							continue;
						}
						// 부활 못할 때
						play.h = 0;
						Player value = new Player(play.h, play.lv, play.attack, play.armor, play.exp, play.weapon,
								play.guard, play.acc);
						finish(idx, value, true);
						return "SPIKE TRAP";
					}
				}
				continue;
			}
			Pos next = new Pos(nx, ny);
			// 아이템
			if (map[nx][ny] == 'B') {
				Box box = item.get(next);
				// 장신구
				// 칸이 남았을 경우 장착
				if (box.type == 'O') {
					String[] already = play.acc;
					int avail = -1;
					for (int i = 0; i < 4; i++) {
						if (avail == -1 && already[i] == null) {
							avail = i;
							continue;
						}
						if (box.s.equals(already[i])) {
							avail = -1;
							break;
						}
					}
					if (avail != -1) {
						already[avail] = box.s;
					}
				} else if (box.type == 'A') {
					play.guard = box.n;
				} else {
					play.weapon = box.n;
				}
				map[nx][ny] = '.';
				item.remove(next);
			}
			// 가시일 때
			else if (map[nx][ny] == '^') {
				int damage = 5;
				for (int i = 0; i < 4; i++) {
					if (play.acc[i] == null) {
						continue;
					}
					if (play.acc[i].equals("DX")) {
						damage = 1;
						break;
					}
				}
				play.h -= damage;
				// 죽었을 때
				if (play.h < 1) {
					// 부활 가능할 경우
					boolean revive = false;
					for (int i = 0; i < 4; i++) {
						if (play.acc[i] == null) {
							continue;
						}
						if (play.acc[i].equals("RE")) {
							reStart(now, play, i);
							revive = true;
							break;
						}
					}
					if (revive) {
						continue;
					}
					play.h = 0;
					Player value = new Player(play.h, play.lv, play.attack, play.armor, play.exp, play.weapon,
							play.guard, play.acc);
					finish(idx, value, true);
					return "SPIKE TRAP";
				}
			}
			// 일반 몬스터
			else if (map[nx][ny] == '&') {
				Monster m = monster.get(next);
				int mH = m.h;
				// 이겼을 때
				if (fight(play, m)) {
					int exp = m.e;
					for (String x : play.acc) {
						if (x == null) {
							continue;
						}
						if (x.equals("HR")) {
							play.h = Math.min(play.h + 3, 20 + (play.lv - 1) * 5);
						}
						if (x.equals("EX")) {
							exp = (int) (exp * 1.2);
						}
					}
					// 경험치 증가
					play.exp += exp;
					// 레벨업 가능할 시 레벨업
					if (play.exp >= play.lv * 5) {
						play.lv++;
						play.h = 20 + (play.lv - 1) * 5;
						play.attack += 2;
						play.armor += 2;
						play.exp = 0;
					}
					map[nx][ny] = '.';
					monster.remove(next);
				}
				// 졌을 때
				else {
					// 부활
					boolean revive = false;
					for (int i = 0; i < 4; i++) {
						if (play.acc[i] == null) {
							continue;
						}
						if (play.acc[i].equals("RE")) {
							monster.put(next, new Monster(m.w, m.a, mH, m.e, m.name));
							reStart(now, play, i);
							revive = true;
						}
					}
					if (revive)
						continue;
					// 부활 못할 경우
					Player value = new Player(play.h, play.lv, play.attack, play.armor, play.exp, play.weapon,
							play.guard, play.acc);
					finish(idx, value, true);
					return m.name;
				}
			}
			// 보스 만났을 때
			else if (map[nx][ny] == 'M') {
				Monster m = monster.get(next);
				int mH = m.h;
				// 이겼을 때
				if (fightBoss(play, m)) {
					int exp = m.e;
					for (String x : play.acc) {
						if (x == null) {
							continue;
						}
						if (x.equals("HR")) {
							play.h = Math.min(play.h + 3, 20 + (play.lv - 1) * 5);
						}
						if (x.equals("EX")) {
							exp = (int) (exp * 1.2);
						}
					}
					// 경험치 증가
					play.exp += exp;
					// 레벨업 가능할 시 레벨업
					if (play.exp >= play.lv * 5) {
						play.lv++;
						play.h = 20 + (play.lv - 1) * 5;
						play.attack += 2;
						play.armor += 2;
						play.exp = 0;
					}

					player.remove(now);
					sx = nx;
					sy = ny;
					Player value = new Player(play.h, play.lv, play.attack, play.armor, play.exp, play.weapon,
							play.guard, play.acc);
					player.put(next, value);
					finish(idx, value, false);
					// 게임 끝
					return "KILL";
				}
				// 졌을 때
				else {
					// 부활
					boolean revive = false;
					for (int i = 0; i < 4; i++) {
						if (play.acc[i] == null) {
							continue;
						}
						if (play.acc[i].equals("RE")) {
							monster.put(next, new Monster(m.w, m.a, mH, m.e, m.name));
							reStart(now, play, i);
							revive = true;
							break;
						}
					}
					if (revive)
						continue;
					Player value = new Player(play.h, play.lv, play.attack, play.armor, play.exp, play.weapon,
							play.guard, play.acc);
					finish(idx, value, true);
					return m.name;
				}

			}
			// 다음 칸 이동
			player.remove(now);
			sx = nx;
			sy = ny;
			player.put(next,
					new Player(play.h, play.lv, play.attack, play.armor, play.exp, play.weapon, play.guard, play.acc));
		}
		finish(idx, player.get(new Pos(sx, sy)), false);
		return "END";
	}

	private static void reStart(Pos now, Player play, int i) {
		player.remove(now);
		play.acc[i] = null;
		sx = rx;
		sy = ry;
		player.put(new Pos(rx, ry), new Player(20 + (play.lv - 1) * 5, play.lv, play.attack, play.armor, play.exp,
				play.weapon, play.guard, play.acc));
	}

	static boolean fight(Player player, Monster monster) {
		int ad = 1;
		boolean check = false;
		for (String s : player.acc) {
			if (s == null) {
				continue;
			}
			if (s.equals("CO")) {
				ad++;
			}
			if (s.equals("DX")) {
				check = true;
			}
		}
		if (check && ad == 2) {
			ad++;
		}

		while (true) {
			monster.h -= Math.max((player.attack + player.weapon) * ad - monster.a, 1);
			if (ad > 1) {
				ad = 1;
			}
			if (monster.h < 1) {
				return true;
			}

			player.h -= Math.max(monster.w - (player.armor + player.guard), 1);

			if (player.h < 1) {
				player.h = 0;
				return false;
			}

		}
	}

	static boolean fightBoss(Player player, Monster monster) {
		boolean shield = false;
		int ad = 1;
		boolean check = false;
		for (String s : player.acc) {
			if (s == null) {
				continue;
			}
			if (s.equals("HU")) {
				shield = true;
			}
			if (s.equals("CO")) {
				ad++;
			}
			if (s.equals("DX")) {
				check = true;
			}
		}

		if (check && ad == 2) {
			ad++;
		}

		if (shield) {
			player.h = 20 + (player.lv - 1) * 5;
		}

		while (true) {
			monster.h -= Math.max((player.attack + player.weapon) * ad - monster.a, 1);
			if (ad > 1) {
				ad = 1;
			}
			if (monster.h < 1) {
				return true;
			}

			if (shield) {
				shield = false;
				continue;
			}

			player.h -= Math.max(monster.w - (player.armor + player.guard), 1);

			if (player.h < 1) {
				player.h = 0;
				return false;
			}
		}
	}

	static void finish(int idx, Player player, boolean die) {
		if (!die)
			map[sx][sy] = '@';
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		sb.append("Passed Turns : ").append(idx + 1).append("\n");
		sb.append("LV : ").append(player.lv).append("\n");
		sb.append("HP : ").append(player.h).append("/").append(20 + (player.lv - 1) * 5).append("\n");
		sb.append("ATT : ").append(player.attack).append('+').append(player.weapon).append("\n");
		sb.append("DEF : ").append(player.armor).append('+').append(player.guard).append("\n");
		sb.append("EXP : ").append(player.exp).append("/").append(player.lv * 5).append("\n");
	}
}