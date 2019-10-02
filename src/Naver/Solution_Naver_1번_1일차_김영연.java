package Naver;


public class Solution_Naver_1번_1일차_김영연 {
	public static void main(String[] emails) {
		int n = emails.length;
		int cnt = 0;
		String[] top = { "com", "net", "org" };
		for (int i = 0; i < n; i++) {
			String str = emails[i];
			int spin = 0; // @ 두번나와는지.
			boolean flag_dot = false; // 첫 골뱅이 이후 .이 찍혔는지?
			boolean flag_top = false; // top도메인형식에 어울리는지
			for (int j = 0; j < str.length(); j++) {
				// 골뱅이 기준으로 세 영역으로 나눠야함
				if (spin == 0) { // 골뱅이가 아직 나오기 전이면
					if (str.charAt(j) == '@')
						spin = 1; // 골뱅이 나왔어!
					continue;
				} else { // 골뱅이 나왔다.
					if (!flag_dot) {
						if (str.charAt(j) == '@') {
							// 또골뱅이면
							spin = 2; // 2로만들고 이미 불가능이므로 break
							break;
						} else if (str.charAt(j) == '.')
							flag_dot = true; // 골뱅이 이후 점이니 이제 다음은 top도메인이여야함
					}
					else { //flag_dot == true
						for(int k=0; k<3; k++) {
							if(str.substring(j, str.length()).equals(top[k]))
								flag_top = true;
						}
					}
				}
			}
			if (spin == 1 && flag_dot && flag_top)
				cnt++;
			// 골뱅이가 1개나왔고 그이후 점이 찍혔고 top형식에 어울리면 cnt ++
		}
		System.out.println(cnt);
	}

}
