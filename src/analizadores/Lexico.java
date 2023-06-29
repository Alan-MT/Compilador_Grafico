package analizadores;
import java_cup.runtime.Symbol; 


public class Lexico implements java_cup.runtime.Scanner {
	private final int YY_BUFFER_SIZE = 512;
	private final int YY_F = -1;
	private final int YY_NO_STATE = -1;
	private final int YY_NOT_ACCEPT = 0;
	private final int YY_START = 1;
	private final int YY_END = 2;
	private final int YY_NO_ANCHOR = 4;
	private final int YY_BOL = 65536;
	private final int YY_EOF = 65537;
	private java.io.BufferedReader yy_reader;
	private int yy_buffer_index;
	private int yy_buffer_read;
	private int yy_buffer_start;
	private int yy_buffer_end;
	private char yy_buffer[];
	private int yychar;
	private int yyline;
	private boolean yy_at_bol;
	private int yy_lexical_state;

	public Lexico (java.io.Reader reader) {
		this ();
		if (null == reader) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(reader);
	}

	public Lexico (java.io.InputStream instream) {
		this ();
		if (null == instream) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(new java.io.InputStreamReader(instream));
	}
        public Lexico(String inputString) {
    this();
    if (null == inputString) {
        throw new Error("Error: Bad input string initializer.");
    }
    yy_reader = new java.io.BufferedReader(new java.io.StringReader(inputString));
}


	private Lexico () {
		yy_buffer = new char[YY_BUFFER_SIZE];
		yy_buffer_read = 0;
		yy_buffer_index = 0;
		yy_buffer_start = 0;
		yy_buffer_end = 0;
		yychar = 0;
		yyline = 0;
		yy_at_bol = true;
		yy_lexical_state = YYINITIAL;
 
    yyline = 1; 
    yychar = 1; 
	}

	private boolean yy_eof_done = false;
	private final int YYINITIAL = 0;
	private final int yy_state_dtrans[] = {
		0
	};
	private void yybegin (int state) {
		yy_lexical_state = state;
	}
	private int yy_advance ()
		throws java.io.IOException {
		int next_read;
		int i;
		int j;

		if (yy_buffer_index < yy_buffer_read) {
			return yy_buffer[yy_buffer_index++];
		}

		if (0 != yy_buffer_start) {
			i = yy_buffer_start;
			j = 0;
			while (i < yy_buffer_read) {
				yy_buffer[j] = yy_buffer[i];
				++i;
				++j;
			}
			yy_buffer_end = yy_buffer_end - yy_buffer_start;
			yy_buffer_start = 0;
			yy_buffer_read = j;
			yy_buffer_index = j;
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}

		while (yy_buffer_index >= yy_buffer_read) {
			if (yy_buffer_index >= yy_buffer.length) {
				yy_buffer = yy_double(yy_buffer);
			}
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}
		return yy_buffer[yy_buffer_index++];
	}
	private void yy_move_end () {
		if (yy_buffer_end > yy_buffer_start &&
		    '\n' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
		if (yy_buffer_end > yy_buffer_start &&
		    '\r' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
	}
	private boolean yy_last_was_cr=false;
	private void yy_mark_start () {
		int i;
		for (i = yy_buffer_start; i < yy_buffer_index; ++i) {
			if ('\n' == yy_buffer[i] && !yy_last_was_cr) {
				++yyline;
			}
			if ('\r' == yy_buffer[i]) {
				++yyline;
				yy_last_was_cr=true;
			} else yy_last_was_cr=false;
		}
		yychar = yychar
			+ yy_buffer_index - yy_buffer_start;
		yy_buffer_start = yy_buffer_index;
	}
	private void yy_mark_end () {
		yy_buffer_end = yy_buffer_index;
	}
	private void yy_to_mark () {
		yy_buffer_index = yy_buffer_end;
		yy_at_bol = (yy_buffer_end > yy_buffer_start) &&
		            ('\r' == yy_buffer[yy_buffer_end-1] ||
		             '\n' == yy_buffer[yy_buffer_end-1] ||
		             2028/*LS*/ == yy_buffer[yy_buffer_end-1] ||
		             2029/*PS*/ == yy_buffer[yy_buffer_end-1]);
	}
	private java.lang.String yytext () {
		return (new java.lang.String(yy_buffer,
			yy_buffer_start,
			yy_buffer_end - yy_buffer_start));
	}
	private int yylength () {
		return yy_buffer_end - yy_buffer_start;
	}
	private char[] yy_double (char buf[]) {
		int i;
		char newbuf[];
		newbuf = new char[2*buf.length];
		for (i = 0; i < buf.length; ++i) {
			newbuf[i] = buf[i];
		}
		return newbuf;
	}
	private final int YY_E_INTERNAL = 0;
	private final int YY_E_MATCH = 1;
	private java.lang.String yy_error_string[] = {
		"Error: Internal error.\n",
		"Error: Unmatched input.\n"
	};
	private void yy_error (int code,boolean fatal) {
		java.lang.System.out.print(yy_error_string[code]);
		java.lang.System.out.flush();
		if (fatal) {
			throw new Error("Fatal Error.\n");
		}
	}
	private int[][] unpackFromString(int size1, int size2, String st) {
		int colonIndex = -1;
		String lengthString;
		int sequenceLength = 0;
		int sequenceInteger = 0;

		int commaIndex;
		String workString;

		int res[][] = new int[size1][size2];
		for (int i= 0; i < size1; i++) {
			for (int j= 0; j < size2; j++) {
				if (sequenceLength != 0) {
					res[i][j] = sequenceInteger;
					sequenceLength--;
					continue;
				}
				commaIndex = st.indexOf(',');
				workString = (commaIndex==-1) ? st :
					st.substring(0, commaIndex);
				st = st.substring(commaIndex+1);
				colonIndex = workString.indexOf(':');
				if (colonIndex == -1) {
					res[i][j]=Integer.parseInt(workString);
					continue;
				}
				lengthString =
					workString.substring(colonIndex+1);
				sequenceLength=Integer.parseInt(lengthString);
				workString=workString.substring(0,colonIndex);
				sequenceInteger=Integer.parseInt(workString);
				res[i][j] = sequenceInteger;
				sequenceLength--;
			}
		}
		return res;
	}
	private int yy_acpt[] = {
		/* 0 */ YY_NOT_ACCEPT,
		/* 1 */ YY_NO_ANCHOR,
		/* 2 */ YY_NO_ANCHOR,
		/* 3 */ YY_NO_ANCHOR,
		/* 4 */ YY_NO_ANCHOR,
		/* 5 */ YY_NO_ANCHOR,
		/* 6 */ YY_NO_ANCHOR,
		/* 7 */ YY_NO_ANCHOR,
		/* 8 */ YY_NO_ANCHOR,
		/* 9 */ YY_NO_ANCHOR,
		/* 10 */ YY_NO_ANCHOR,
		/* 11 */ YY_NO_ANCHOR,
		/* 12 */ YY_NO_ANCHOR,
		/* 13 */ YY_NO_ANCHOR,
		/* 14 */ YY_NO_ANCHOR,
		/* 15 */ YY_NO_ANCHOR,
		/* 16 */ YY_NO_ANCHOR,
		/* 17 */ YY_NO_ANCHOR,
		/* 18 */ YY_NO_ANCHOR,
		/* 19 */ YY_NO_ANCHOR,
		/* 20 */ YY_NO_ANCHOR,
		/* 21 */ YY_NO_ANCHOR,
		/* 22 */ YY_NO_ANCHOR,
		/* 23 */ YY_NO_ANCHOR,
		/* 24 */ YY_NO_ANCHOR,
		/* 25 */ YY_NO_ANCHOR,
		/* 26 */ YY_NO_ANCHOR,
		/* 27 */ YY_NO_ANCHOR,
		/* 28 */ YY_NO_ANCHOR,
		/* 29 */ YY_NO_ANCHOR,
		/* 30 */ YY_NO_ANCHOR,
		/* 31 */ YY_NO_ANCHOR,
		/* 32 */ YY_NO_ANCHOR,
		/* 33 */ YY_NO_ANCHOR,
		/* 34 */ YY_NO_ANCHOR,
		/* 35 */ YY_NO_ANCHOR,
		/* 36 */ YY_NO_ANCHOR,
		/* 37 */ YY_NO_ANCHOR,
		/* 38 */ YY_NOT_ACCEPT,
		/* 39 */ YY_NO_ANCHOR,
		/* 40 */ YY_NO_ANCHOR,
		/* 41 */ YY_NO_ANCHOR,
		/* 42 */ YY_NOT_ACCEPT,
		/* 43 */ YY_NO_ANCHOR,
		/* 44 */ YY_NO_ANCHOR,
		/* 45 */ YY_NOT_ACCEPT,
		/* 46 */ YY_NO_ANCHOR,
		/* 47 */ YY_NO_ANCHOR,
		/* 48 */ YY_NO_ANCHOR,
		/* 49 */ YY_NO_ANCHOR,
		/* 50 */ YY_NO_ANCHOR,
		/* 51 */ YY_NO_ANCHOR,
		/* 52 */ YY_NO_ANCHOR,
		/* 53 */ YY_NO_ANCHOR,
		/* 54 */ YY_NO_ANCHOR,
		/* 55 */ YY_NO_ANCHOR,
		/* 56 */ YY_NO_ANCHOR,
		/* 57 */ YY_NO_ANCHOR,
		/* 58 */ YY_NO_ANCHOR,
		/* 59 */ YY_NO_ANCHOR,
		/* 60 */ YY_NO_ANCHOR,
		/* 61 */ YY_NO_ANCHOR,
		/* 62 */ YY_NO_ANCHOR,
		/* 63 */ YY_NO_ANCHOR,
		/* 64 */ YY_NO_ANCHOR,
		/* 65 */ YY_NO_ANCHOR,
		/* 66 */ YY_NO_ANCHOR,
		/* 67 */ YY_NO_ANCHOR,
		/* 68 */ YY_NO_ANCHOR,
		/* 69 */ YY_NO_ANCHOR,
		/* 70 */ YY_NO_ANCHOR,
		/* 71 */ YY_NO_ANCHOR,
		/* 72 */ YY_NO_ANCHOR,
		/* 73 */ YY_NO_ANCHOR,
		/* 74 */ YY_NO_ANCHOR,
		/* 75 */ YY_NO_ANCHOR,
		/* 76 */ YY_NO_ANCHOR,
		/* 77 */ YY_NO_ANCHOR,
		/* 78 */ YY_NO_ANCHOR,
		/* 79 */ YY_NO_ANCHOR,
		/* 80 */ YY_NO_ANCHOR,
		/* 81 */ YY_NO_ANCHOR,
		/* 82 */ YY_NO_ANCHOR,
		/* 83 */ YY_NO_ANCHOR,
		/* 84 */ YY_NO_ANCHOR,
		/* 85 */ YY_NO_ANCHOR,
		/* 86 */ YY_NO_ANCHOR,
		/* 87 */ YY_NO_ANCHOR,
		/* 88 */ YY_NO_ANCHOR,
		/* 89 */ YY_NO_ANCHOR,
		/* 90 */ YY_NO_ANCHOR,
		/* 91 */ YY_NO_ANCHOR,
		/* 92 */ YY_NO_ANCHOR,
		/* 93 */ YY_NO_ANCHOR
	};
	private int yy_cmap[] = unpackFromString(1,65538,
"2:9,38,37,2:2,38,2:18,38,32,1,2:5,24,25,30,28,36,29,42,31,41:10,2,23,34,33," +
"35,2:2,11,15,9,7,8,20,18,39,4,39,22,10,5,13,19,6,39,12,16,17,14,21,39:4,2,3" +
",2:2,40,2,11,15,9,7,8,20,18,39,4,39,22,10,5,13,19,6,39,12,16,17,14,21,39:4," +
"26,43,27,2:65410,0:2")[0];

	private int yy_rmap[] = unpackFromString(1,94,
"0,1,2,3,1:9,4,5,6,1:2,7,8,1,9,1:4,10,11,10:10,2,1,12,2,13,14,15,11,16,17,18" +
",19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43" +
",44,45,46,47,48,49,50,51,52,53,54,55,56,57,10,58,59,60,61,62")[0];

	private int yy_nxt[][] = unpackFromString(63,44,
"1,2,39:2,3,76,85,87,88:4,89,90,88,91,40,88:3,92,93,88,4,5,6,7,8,9,10,11,12," +
"43,13,14,15,16,17,18,88,39,19,39:2,-1:45,20,38,42,38:33,-1,38:6,-1:4,88,44," +
"88:17,-1:16,88,46:2,-1:35,23,-1:43,24,-1:43,25,-1:48,18,-1:46,19,45,-1:5,88" +
":9,59,88:9,-1:16,88,46:2,-1:6,88:19,-1:16,88,46:2,-1:43,27,-1,27,-1:4,21,88" +
":12,78,88:5,-1:16,88,46:2,-1:3,41,38,42,38:33,-1,38:6,-1:33,22,-1:14,88:2,2" +
"6,88:16,-1:16,88,46:2,-1:6,46:19,-1:16,46:3,-1:6,88:4,79,88:14,-1:16,88,46:" +
"2,-1:6,88:8,54,88:10,-1:16,88,46:2,-1:6,88:5,55,88:13,-1:16,88,46:2,-1:6,88" +
":13,56,88:5,-1:16,88,46:2,-1:6,88,57,88:17,-1:16,88,46:2,-1:6,88:9,60,88:9," +
"-1:16,88,46:2,-1:6,61,88:18,-1:16,88,46:2,-1:6,88:7,28,88:11,-1:16,88,46:2," +
"-1:6,88:6,81,88:12,-1:16,88,46:2,-1:6,88:15,63,88:3,-1:16,88,46:2,-1:6,88:1" +
"1,64,88:7,-1:16,88,46:2,-1:6,88:7,65,88:11,-1:16,88,46:2,-1:6,88:15,29,88:3" +
",-1:16,88,46:2,-1:6,88:5,67,88:13,-1:16,88,46:2,-1:6,88:3,30,88:15,-1:16,88" +
",46:2,-1:6,88:13,82,88:5,-1:16,88,46:2,-1:6,88:8,83,88:10,-1:16,88,46:2,-1:" +
"6,88:4,68,88:14,-1:16,88,46:2,-1:6,88:18,31,-1:16,88,46:2,-1:6,88:9,69,88:9" +
",-1:16,88,46:2,-1:6,70,88:18,-1:16,88,46:2,-1:6,88:8,32,88:10,-1:16,88,46:2" +
",-1:6,88:14,33,88:4,-1:16,88,46:2,-1:6,88:15,73,88:3,-1:16,88,46:2,-1:6,88:" +
"7,74,88:11,-1:16,88,46:2,-1:6,88:7,34,88:11,-1:16,88,46:2,-1:6,88:9,35,88:9" +
",-1:16,88,46:2,-1:6,88:12,36,88:6,-1:16,88,46:2,-1:6,88:8,37,88:10,-1:16,88" +
",46:2,-1:6,47,88:18,-1:16,88,46:2,-1:6,88:4,58,88:14,-1:16,88,46:2,-1:6,88:" +
"8,80,88:10,-1:16,88,46:2,-1:6,88:9,62,88:9,-1:16,88,46:2,-1:6,66,88:18,-1:1" +
"6,88,46:2,-1:6,88:7,86,88:11,-1:16,88,46:2,-1:6,88:8,71,88:10,-1:16,88,46:2" +
",-1:6,88:9,84,88:9,-1:16,88,46:2,-1:6,88:7,75,88:11,-1:16,88,46:2,-1:6,88:7" +
",48,88:11,-1:16,88,46:2,-1:6,88:8,72,88:10,-1:16,88,46:2,-1:6,88:4,49,88:14" +
",-1:16,88,46:2,-1:6,88:4,50,88:14,-1:16,88,46:2,-1:6,88:10,51,88:8,-1:16,88" +
",46:2,-1:6,88:8,77,88:10,-1:16,88,46:2,-1:6,88:10,52,88:8,-1:16,88,46:2,-1:" +
"6,88:15,53,88:3,-1:16,88,46:2,-1:2");

	public java_cup.runtime.Symbol next_token ()
		throws java.io.IOException {
		int yy_lookahead;
		int yy_anchor = YY_NO_ANCHOR;
		int yy_state = yy_state_dtrans[yy_lexical_state];
		int yy_next_state = YY_NO_STATE;
		int yy_last_accept_state = YY_NO_STATE;
		boolean yy_initial = true;
		int yy_this_accept;

		yy_mark_start();
		yy_this_accept = yy_acpt[yy_state];
		if (YY_NOT_ACCEPT != yy_this_accept) {
			yy_last_accept_state = yy_state;
			yy_mark_end();
		}
		while (true) {
			if (yy_initial && yy_at_bol) yy_lookahead = YY_BOL;
			else yy_lookahead = yy_advance();
			yy_next_state = YY_F;
			yy_next_state = yy_nxt[yy_rmap[yy_state]][yy_cmap[yy_lookahead]];
			if (YY_EOF == yy_lookahead && true == yy_initial) {
				return null;
			}
			if (YY_F != yy_next_state) {
				yy_state = yy_next_state;
				yy_initial = false;
				yy_this_accept = yy_acpt[yy_state];
				if (YY_NOT_ACCEPT != yy_this_accept) {
					yy_last_accept_state = yy_state;
					yy_mark_end();
				}
			}
			else {
				if (YY_NO_STATE == yy_last_accept_state) {
					throw (new Error("Lexical Error: Unmatched Input."));
				}
				else {
					yy_anchor = yy_acpt[yy_last_accept_state];
					if (0 != (YY_END & yy_anchor)) {
						yy_move_end();
					}
					yy_to_mark();
					switch (yy_last_accept_state) {
					case 1:
						
					case -2:
						break;
					case 2:
						{
    System.err.println("Este es un error lexico: "+yytext()+", en la linea: "+yyline+", en la columna: "+yychar);
}
					case -3:
						break;
					case 3:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -4:
						break;
					case 4:
						{return new Symbol(sym.PTCOMA,yyline,yychar, yytext());}
					case -5:
						break;
					case 5:
						{return new Symbol(sym.PARIZQ,yyline,yychar, yytext());}
					case -6:
						break;
					case 6:
						{return new Symbol(sym.PARDER,yyline,yychar, yytext());}
					case -7:
						break;
					case 7:
						{return new Symbol(sym.LLAVIZQ,yyline,yychar, yytext());}
					case -8:
						break;
					case 8:
						{return new Symbol(sym.LLAVDER,yyline,yychar, yytext());}
					case -9:
						break;
					case 9:
						{return new Symbol(sym.MAS,yyline,yychar, yytext());}
					case -10:
						break;
					case 10:
						{return new Symbol(sym.MENOS,yyline,yychar, yytext());}
					case -11:
						break;
					case 11:
						{return new Symbol(sym.POR,yyline,yychar, yytext());}
					case -12:
						break;
					case 12:
						{return new Symbol(sym.DIVIDIDO,yyline,yychar, yytext());}
					case -13:
						break;
					case 13:
						{return new Symbol(sym.IGUAL,yyline,yychar, yytext());}
					case -14:
						break;
					case 14:
						{return new Symbol(sym.MENQUE,yyline,yychar, yytext());}
					case -15:
						break;
					case 15:
						{return new Symbol(sym.MAYQUE,yyline,yychar, yytext());}
					case -16:
						break;
					case 16:
						{return new Symbol(sym.COMA,yyline,yychar, yytext());}
					case -17:
						break;
					case 17:
						{yychar=1;}
					case -18:
						break;
					case 18:
						{}
					case -19:
						break;
					case 19:
						{return new Symbol(sym.ENTERO,yyline,yychar, yytext());}
					case -20:
						break;
					case 20:
						{return new Symbol(sym.CADENA,yyline,yychar, (yytext()).substring(1,yytext().length()-1));}
					case -21:
						break;
					case 21:
						{return new Symbol(sym.RIF,yyline,yychar, yytext());}
					case -22:
						break;
					case 22:
						{return new Symbol (sym.DIFQUE,yyline,yychar, yytext());}
					case -23:
						break;
					case 23:
						{return new Symbol(sym.IGUALQUE,yyline,yychar, yytext());}
					case -24:
						break;
					case 24:
						{return new Symbol(sym.MENIGUALQUE,yyline,yychar, yytext());}
					case -25:
						break;
					case 25:
						{return new Symbol(sym.MAYIGUALQUE,yyline,yychar, yytext());}
					case -26:
						break;
					case 26:
						{return new Symbol(sym.RPRINT,yyline,yychar, yytext());}
					case -27:
						break;
					case 27:
						{return new Symbol(sym.DECIMAL,yyline,yychar, yytext());}
					case -28:
						break;
					case 28:
						{return new Symbol(sym.RFOR,yyline,yychar, yytext());}
					case -29:
						break;
					case 29:
						{return new Symbol(sym.RELSE,yyline,yychar, yytext());}
					case -30:
						break;
					case 30:
						{return new Symbol(sym.RVOID,yyline,yychar, yytext());}
					case -31:
						break;
					case 31:
						{return new Symbol(sym.RBREAK,yyline,yychar, yytext());}
					case -32:
						break;
					case 32:
						{return new Symbol(sym.RNUMBER,yyline,yychar, yytext());}
					case -33:
						break;
					case 33:
						{return new Symbol(sym.RSTRING,yyline,yychar, yytext());}
					case -34:
						break;
					case 34:
						{return new Symbol(sym.RDECLARA,yyline,yychar, yytext());}
					case -35:
						break;
					case 35:
						{return new Symbol(sym.RFUNCTION,yyline,yychar, yytext());}
					case -36:
						break;
					case 36:
						{return new Symbol(sym.RWHILE,yyline,yychar, yytext());}
					case -37:
						break;
					case 37:
						{return new Symbol(sym.RRETURN,yyline,yychar, yytext());}
					case -38:
						break;
					case 39:
						{
    System.err.println("Este es un error lexico: "+yytext()+", en la linea: "+yyline+", en la columna: "+yychar);
}
					case -39:
						break;
					case 40:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -40:
						break;
					case 41:
						{return new Symbol(sym.CADENA,yyline,yychar, (yytext()).substring(1,yytext().length()-1));}
					case -41:
						break;
					case 43:
						{
    System.err.println("Este es un error lexico: "+yytext()+", en la linea: "+yyline+", en la columna: "+yychar);
}
					case -42:
						break;
					case 44:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -43:
						break;
					case 46:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -44:
						break;
					case 47:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -45:
						break;
					case 48:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -46:
						break;
					case 49:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -47:
						break;
					case 50:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -48:
						break;
					case 51:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -49:
						break;
					case 52:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -50:
						break;
					case 53:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -51:
						break;
					case 54:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -52:
						break;
					case 55:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -53:
						break;
					case 56:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -54:
						break;
					case 57:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -55:
						break;
					case 58:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -56:
						break;
					case 59:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -57:
						break;
					case 60:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -58:
						break;
					case 61:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -59:
						break;
					case 62:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -60:
						break;
					case 63:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -61:
						break;
					case 64:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -62:
						break;
					case 65:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -63:
						break;
					case 66:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -64:
						break;
					case 67:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -65:
						break;
					case 68:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -66:
						break;
					case 69:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -67:
						break;
					case 70:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -68:
						break;
					case 71:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -69:
						break;
					case 72:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -70:
						break;
					case 73:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -71:
						break;
					case 74:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -72:
						break;
					case 75:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -73:
						break;
					case 76:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -74:
						break;
					case 77:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -75:
						break;
					case 78:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -76:
						break;
					case 79:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -77:
						break;
					case 80:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -78:
						break;
					case 81:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -79:
						break;
					case 82:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -80:
						break;
					case 83:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -81:
						break;
					case 84:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -82:
						break;
					case 85:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -83:
						break;
					case 86:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -84:
						break;
					case 87:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -85:
						break;
					case 88:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -86:
						break;
					case 89:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -87:
						break;
					case 90:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -88:
						break;
					case 91:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -89:
						break;
					case 92:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -90:
						break;
					case 93:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -91:
						break;
					default:
						yy_error(YY_E_INTERNAL,false);
					case -1:
					}
					yy_initial = true;
					yy_state = yy_state_dtrans[yy_lexical_state];
					yy_next_state = YY_NO_STATE;
					yy_last_accept_state = YY_NO_STATE;
					yy_mark_start();
					yy_this_accept = yy_acpt[yy_state];
					if (YY_NOT_ACCEPT != yy_this_accept) {
						yy_last_accept_state = yy_state;
						yy_mark_end();
					}
				}
			}
		}
	}
}
