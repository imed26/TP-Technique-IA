package SmartRobotStrictLivenes;

public class RobotMain {
	static CoreControl.Grid grid = new CoreControl.Grid();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] commande = new String[3];
		String argument ="";

		// Exemple de 4 robots

		argument = argument+"P1:SmartRobotStrictLivenes.RobotAgent(0,0,4,4,1#P2#P3#P4)";
		argument = argument+";";
		argument = argument+"P2:SmartRobotStrictLivenes.RobotAgent(4,0,0,4,2#P1#P3#P4)";
		argument = argument+";";
		argument = argument+"P3:SmartRobotStrictLivenes.RobotAgent(0,4,4,0,3#P1#P2#P4)";
		argument = argument+";";
		argument = argument+"P4:SmartRobotStrictLivenes.RobotAgent(4,4,0,0,4#P1#P2#P3)";

		// Exemple de 7 robots avec diagonale fermée et deux robots qui traversent la diagonale
		/*
		argument = argument+"P1:SmartRobotStrictLivenes.RobotAgent(0,4,4,0,1#P2#P3#P4#P5#P6#P7)";
		argument = argument+";";
		argument = argument+"P2:SmartRobotStrictLivenes.RobotAgent(0,0,0,0,2#P1#P3#P4#P5#P6#P7)";
		argument = argument+";";
		argument = argument+"P3:SmartRobotStrictLivenes.RobotAgent(1,1,1,1,3#P1#P2#P4#P5#P6#P7)";
		argument = argument+";";
		argument = argument+"P4:SmartRobotStrictLivenes.RobotAgent(2,2,2,2,4#P1#P2#P3#P5#P6#P7)";
		argument = argument+";";
		argument = argument+"P5:SmartRobotStrictLivenes.RobotAgent(3,3,3,3,5#P1#P2#P3#P4#P6#P7)";
		argument = argument+";";
		argument = argument+"P6:SmartRobotStrictLivenes.RobotAgent(4,4,4,4,6#P1#P2#P3#P4#P5#P7)";
		argument = argument+";";
		argument = argument+"P7:SmartRobotStrictLivenes.RobotAgent(4,0,0,4,7#P1#P2#P3#P4#P5#P6)";
		*/

		// Exemple de 13 robots qui forment à la fin un U inversé: Le programme à mis 1 minute, il peut aussi diverger
		/*
		argument = argument+"P1:SmartRobotStrictLivenes.RobotAgent(1,1,0,0,1#P2#P3#P4#P5#P6#P7#P8#P9#P10#P11#P12#P13)";
		argument = argument+";";
		argument = argument+"P2:SmartRobotStrictLivenes.RobotAgent(1,2,0,1,2#P1#P3#P4#P5#P6#P7#P8#P9#P10#P11#P12#P13)";
		argument = argument+";";
		argument = argument+"P3:SmartRobotStrictLivenes.RobotAgent(1,3,0,2,3#P1#P2#P4#P5#P6#P7#P8#P9#P10#P11#P12#P13)";
		argument = argument+";";
		argument = argument+"P4:SmartRobotStrictLivenes.RobotAgent(1,4,0,3,4#P1#P2#P3#P5#P6#P7#P8#P9#P10#P11#P12#P13)";
		argument = argument+";";
		argument = argument+"P5:SmartRobotStrictLivenes.RobotAgent(2,2,0,4,5#P1#P2#P3#P4#P6#P7#P8#P9#P10#P11#P12#P13)";
		argument = argument+";";
		argument = argument+"P6:SmartRobotStrictLivenes.RobotAgent(2,3,1,0,6#P1#P2#P3#P4#P5#P7#P8#P9#P10#P11#P12#P13)";
		argument = argument+";";
		argument = argument+"P7:SmartRobotStrictLivenes.RobotAgent(2,4,2,0,7#P1#P2#P3#P4#P5#P6#P8#P9#P10#P11#P12#P13)";
		argument = argument+";";
		argument = argument+"P8:SmartRobotStrictLivenes.RobotAgent(3,2,3,0,8#P1#P2#P3#P4#P5#P6#P7#P9#P10#P11#P12#P13)";
		argument = argument+";";
		argument = argument+"P9:SmartRobotStrictLivenes.RobotAgent(3,3,4,0,9#P1#P2#P3#P4#P5#P6#P7#P8#P10#P11#P12#P13)";
		argument = argument+";";
		argument = argument+"P10:SmartRobotStrictLivenes.RobotAgent(3,4,4,1,10#P1#P2#P3#P4#P5#P6#P7#P8#P9#P11#P12#P13)";
		argument = argument+";";
		argument = argument+"P11:SmartRobotStrictLivenes.RobotAgent(4,0,4,2,11#P1#P2#P3#P4#P5#P6#P7#P8#P9#P10#P12#P13)";
		argument = argument+";";
		argument = argument+"P12:SmartRobotStrictLivenes.RobotAgent(4,1,4,3,12#P1#P2#P3#P4#P5#P6#P7#P8#P9#P10#P11#P13)";
		argument = argument+";";
		argument = argument+"P13:SmartRobotStrictLivenes.RobotAgent(4,2,4,4,13#P1#P2#P3#P4#P5#P6#P7#P8#P9#P10#P11#P12)";
		*/

		// Exemple de 16 robots: Convergence après 3 minutes mais peut aussi ne pas converger
		/*
		argument = argument+"P1:SmartRobotStrictLivenes.RobotAgent(1,1,0,0,1#P2#P3#P4#P5#P6#P7#P8#P9#P10#P11#P12#P13#P14#P15#P16)";
		argument = argument+";";
		argument = argument+"P2:SmartRobotStrictLivenes.RobotAgent(1,2,0,1,2#P1#P3#P4#P5#P6#P7#P8#P9#P10#P11#P12#P13#P14#P15#P16)";
		argument = argument+";";
		argument = argument+"P3:SmartRobotStrictLivenes.RobotAgent(1,3,0,2,3#P1#P2#P4#P5#P6#P7#P8#P9#P10#P11#P12#P13#P14#P15#P16)";
		argument = argument+";";
		argument = argument+"P4:SmartRobotStrictLivenes.RobotAgent(1,4,0,3,4#P1#P2#P3#P5#P6#P7#P8#P9#P10#P11#P12#P13#P14#P15#P16)";
		argument = argument+";";
		argument = argument+"P5:SmartRobotStrictLivenes.RobotAgent(2,2,0,4,5#P1#P2#P3#P4#P6#P7#P8#P9#P10#P11#P12#P13#P14#P15#P16)";
		argument = argument+";";
		argument = argument+"P6:SmartRobotStrictLivenes.RobotAgent(2,3,1,0,6#P1#P2#P3#P4#P5#P7#P8#P9#P10#P11#P12#P13#P14#P15#P16)";
		argument = argument+";";
		argument = argument+"P7:SmartRobotStrictLivenes.RobotAgent(2,4,2,0,7#P1#P2#P3#P4#P5#P6#P8#P9#P10#P11#P12#P13#P14#P15#P16)";
		argument = argument+";";
		argument = argument+"P8:SmartRobotStrictLivenes.RobotAgent(3,2,3,0,8#P1#P2#P3#P4#P5#P6#P7#P9#P10#P11#P12#P13#P14#P15#P16)";
		argument = argument+";";
		argument = argument+"P9:SmartRobotStrictLivenes.RobotAgent(3,3,4,0,9#P1#P2#P3#P4#P5#P6#P7#P8#P10#P11#P12#P13#P14#P15#P16)";
		argument = argument+";";
		argument = argument+"P10:SmartRobotStrictLivenes.RobotAgent(3,4,4,1,10#P1#P2#P3#P4#P5#P6#P7#P8#P9#P11#P12#P13#P14#P15#P16)";
		argument = argument+";";
		argument = argument+"P11:SmartRobotStrictLivenes.RobotAgent(4,0,4,2,11#P1#P2#P3#P4#P5#P6#P7#P8#P9#P10#P12#P13#P14#P15#P16)";
		argument = argument+";";
		argument = argument+"P12:SmartRobotStrictLivenes.RobotAgent(4,1,4,3,12#P1#P2#P3#P4#P5#P6#P7#P8#P9#P10#P11#P13#P14#P15#P16)";
		argument = argument+";";
		argument = argument+"P13:SmartRobotStrictLivenes.RobotAgent(4,2,4,4,13#P1#P2#P3#P4#P5#P6#P7#P8#P9#P10#P11#P12#P14#P15#P16)";
		argument = argument+";";
		argument = argument+"P14:SmartRobotStrictLivenes.RobotAgent(0,0,1,4,14#P1#P2#P3#P4#P5#P6#P7#P8#P9#P10#P11#P12#P13#P15#P16)";
		argument = argument+";";
		argument = argument+"P15:SmartRobotStrictLivenes.RobotAgent(4,3,2,4,15#P1#P2#P3#P4#P5#P6#P7#P8#P9#P10#P11#P12#P13#P14#P16)";
		argument = argument+";";
		argument = argument+"P16:SmartRobotStrictLivenes.RobotAgent(4,4,3,4,16#P1#P2#P3#P4#P5#P6#P7#P8#P9#P10#P11#P12#P13#P14#P15)";
		*/
		// Exemple de 17 robots: Convergence après 9 minutes
		/*
		argument = argument+"P1:SmartRobotStrictLivenes.RobotAgent(1,1,0,0,1#P2#P3#P4#P5#P6#P7#P8#P9#P10#P11#P12#P13#P14#P15#P16#P17)";
		argument = argument+";";
		argument = argument+"P2:SmartRobotStrictLivenes.RobotAgent(1,2,0,1,2#P1#P3#P4#P5#P6#P7#P8#P9#P10#P11#P12#P13#P14#P15#P16#P17)";
		argument = argument+";";
		argument = argument+"P3:SmartRobotStrictLivenes.RobotAgent(1,3,0,2,3#P1#P2#P4#P5#P6#P7#P8#P9#P10#P11#P12#P13#P14#P15#P16#P17)";
		argument = argument+";";
		argument = argument+"P4:SmartRobotStrictLivenes.RobotAgent(1,4,0,3,4#P1#P2#P3#P5#P6#P7#P8#P9#P10#P11#P12#P13#P14#P15#P16#P17)";
		argument = argument+";";
		argument = argument+"P5:SmartRobotStrictLivenes.RobotAgent(2,2,0,4,5#P1#P2#P3#P4#P6#P7#P8#P9#P10#P11#P12#P13#P14#P15#P16#P17)";
		argument = argument+";";
		argument = argument+"P6:SmartRobotStrictLivenes.RobotAgent(2,3,1,0,6#P1#P2#P3#P4#P5#P7#P8#P9#P10#P11#P12#P13#P14#P15#P16#P17)";
		argument = argument+";";
		argument = argument+"P7:SmartRobotStrictLivenes.RobotAgent(2,4,2,0,7#P1#P2#P3#P4#P5#P6#P8#P9#P10#P11#P12#P13#P14#P15#P16#P17)";
		argument = argument+";";
		argument = argument+"P8:SmartRobotStrictLivenes.RobotAgent(3,2,3,0,8#P1#P2#P3#P4#P5#P6#P7#P9#P10#P11#P12#P13#P14#P15#P16#P17)";
		argument = argument+";";
		argument = argument+"P9:SmartRobotStrictLivenes.RobotAgent(3,3,4,0,9#P1#P2#P3#P4#P5#P6#P7#P8#P10#P11#P12#P13#P14#P15#P16#P17)";
		argument = argument+";";
		argument = argument+"P10:SmartRobotStrictLivenes.RobotAgent(3,4,4,1,10#P1#P2#P3#P4#P5#P6#P7#P8#P9#P11#P12#P13#P14#P15#P16#P17)";
		argument = argument+";";
		argument = argument+"P11:SmartRobotStrictLivenes.RobotAgent(4,0,4,2,11#P1#P2#P3#P4#P5#P6#P7#P8#P9#P10#P12#P13#P14#P15#P16#P17)";
		argument = argument+";";
		argument = argument+"P12:SmartRobotStrictLivenes.RobotAgent(4,1,4,3,12#P1#P2#P3#P4#P5#P6#P7#P8#P9#P10#P11#P13#P14#P15#P16#P17)";
		argument = argument+";";
		argument = argument+"P13:SmartRobotStrictLivenes.RobotAgent(4,2,4,4,13#P1#P2#P3#P4#P5#P6#P7#P8#P9#P10#P11#P12#P14#P15#P16#P17)";
		argument = argument+";";
		argument = argument+"P14:SmartRobotStrictLivenes.RobotAgent(0,0,1,4,14#P1#P2#P3#P4#P5#P6#P7#P8#P9#P10#P11#P12#P13#P15#P16#P17)";
		argument = argument+";";
		argument = argument+"P15:SmartRobotStrictLivenes.RobotAgent(4,3,2,4,15#P1#P2#P3#P4#P5#P6#P7#P8#P9#P10#P11#P12#P13#P14#P16#P17)";
		argument = argument+";";
		argument = argument+"P16:SmartRobotStrictLivenes.RobotAgent(4,4,3,4,16#P1#P2#P3#P4#P5#P6#P7#P8#P9#P10#P11#P12#P13#P14#P15#P17)";
		argument = argument+";";
		argument = argument+"P17:SmartRobotStrictLivenes.RobotAgent(0,1,2,1,17#P1#P2#P3#P4#P5#P6#P7#P8#P9#P10#P11#P12#P13#P14#P15#P16)";
		*/


		// Exemple de 18 robots: Convergence après 10 minutes
		/*
		argument = argument+"P1:SmartRobotStrictLivenes.RobotAgent(1,1,0,0,1#P2#P3#P4#P5#P6#P7#P8#P9#P10#P11#P12#P13#P14#P15#P16#P17#P18)";
		argument = argument+";";
		argument = argument+"P2:SmartRobotStrictLivenes.RobotAgent(1,2,0,1,2#P1#P3#P4#P5#P6#P7#P8#P9#P10#P11#P12#P13#P14#P15#P16#P17#P18)";
		argument = argument+";";
		argument = argument+"P3:SmartRobotStrictLivenes.RobotAgent(1,3,0,2,3#P1#P2#P4#P5#P6#P7#P8#P9#P10#P11#P12#P13#P14#P15#P16#P17#P18)";
		argument = argument+";";
		argument = argument+"P4:SmartRobotStrictLivenes.RobotAgent(1,4,0,3,4#P1#P2#P3#P5#P6#P7#P8#P9#P10#P11#P12#P13#P14#P15#P16#P17#P18)";
		argument = argument+";";
		argument = argument+"P5:SmartRobotStrictLivenes.RobotAgent(2,2,0,4,5#P1#P2#P3#P4#P6#P7#P8#P9#P10#P11#P12#P13#P14#P15#P16#P17#P18)";
		argument = argument+";";
		argument = argument+"P6:SmartRobotStrictLivenes.RobotAgent(2,3,1,0,6#P1#P2#P3#P4#P5#P7#P8#P9#P10#P11#P12#P13#P14#P15#P16#P17#P18)";
		argument = argument+";";
		argument = argument+"P7:SmartRobotStrictLivenes.RobotAgent(2,4,2,0,7#P1#P2#P3#P4#P5#P6#P8#P9#P10#P11#P12#P13#P14#P15#P16#P17#P18)";
		argument = argument+";";
		argument = argument+"P8:SmartRobotStrictLivenes.RobotAgent(3,2,3,0,8#P1#P2#P3#P4#P5#P6#P7#P9#P10#P11#P12#P13#P14#P15#P16#P17#P18)";
		argument = argument+";";
		argument = argument+"P9:SmartRobotStrictLivenes.RobotAgent(3,3,4,0,9#P1#P2#P3#P4#P5#P6#P7#P8#P10#P11#P12#P13#P14#P15#P16#P17#P18)";
		argument = argument+";";
		argument = argument+"P10:SmartRobotStrictLivenes.RobotAgent(3,4,4,1,10#P1#P2#P3#P4#P5#P6#P7#P8#P9#P11#P12#P13#P14#P15#P16#P17#P18)";
		argument = argument+";";
		argument = argument+"P11:SmartRobotStrictLivenes.RobotAgent(4,0,4,2,11#P1#P2#P3#P4#P5#P6#P7#P8#P9#P10#P12#P13#P14#P15#P16#P17#P18)";
		argument = argument+";";
		argument = argument+"P12:SmartRobotStrictLivenes.RobotAgent(4,1,4,3,12#P1#P2#P3#P4#P5#P6#P7#P8#P9#P10#P11#P13#P14#P15#P16#P17#P18)";
		argument = argument+";";
		argument = argument+"P13:SmartRobotStrictLivenes.RobotAgent(4,2,4,4,13#P1#P2#P3#P4#P5#P6#P7#P8#P9#P10#P11#P12#P14#P15#P16#P17#P18)";
		argument = argument+";";
		argument = argument+"P14:SmartRobotStrictLivenes.RobotAgent(0,0,1,4,14#P1#P2#P3#P4#P5#P6#P7#P8#P9#P10#P11#P12#P13#P15#P16#P17#P18)";
		argument = argument+";";
		argument = argument+"P15:SmartRobotStrictLivenes.RobotAgent(4,3,2,4,15#P1#P2#P3#P4#P5#P6#P7#P8#P9#P10#P11#P12#P13#P14#P16#P17#P18)";
		argument = argument+";";
		argument = argument+"P16:SmartRobotStrictLivenes.RobotAgent(4,4,3,4,16#P1#P2#P3#P4#P5#P6#P7#P8#P9#P10#P11#P12#P13#P14#P15#P17#P18)";
		argument = argument+";";
		argument = argument+"P17:SmartRobotStrictLivenes.RobotAgent(0,1,2,1,17#P1#P2#P3#P4#P5#P6#P7#P8#P9#P10#P11#P12#P13#P14#P15#P16#P18)";
		argument = argument+";";
		argument = argument+"P18:SmartRobotStrictLivenes.RobotAgent(0,2,2,3,18#P1#P2#P3#P4#P5#P6#P7#P8#P9#P10#P11#P12#P13#P14#P15#P16#P17)";
		*/


		// Exemple de 19 robots: Après 1h30mn 16 robots sont arrivés à destination
		/*
		argument = argument+"P1:SmartRobotStrictLivenes.RobotAgent(1,1,0,0,1#P2#P3#P4#P5#P6#P7#P8#P9#P10#P11#P12#P13#P14#P15#P16#P17#P18#P19)";
		argument = argument+";";
		argument = argument+"P2:SmartRobotStrictLivenes.RobotAgent(1,2,0,1,2#P1#P3#P4#P5#P6#P7#P8#P9#P10#P11#P12#P13#P14#P15#P16#P17#P18#P19)";
		argument = argument+";";
		argument = argument+"P3:SmartRobotStrictLivenes.RobotAgent(1,3,0,2,3#P1#P2#P4#P5#P6#P7#P8#P9#P10#P11#P12#P13#P14#P15#P16#P17#P18#P19)";
		argument = argument+";";
		argument = argument+"P4:SmartRobotStrictLivenes.RobotAgent(1,4,0,3,4#P1#P2#P3#P5#P6#P7#P8#P9#P10#P11#P12#P13#P14#P15#P16#P17#P18#P19)";
		argument = argument+";";
		argument = argument+"P5:SmartRobotStrictLivenes.RobotAgent(2,2,0,4,5#P1#P2#P3#P4#P6#P7#P8#P9#P10#P11#P12#P13#P14#P15#P16#P17#P18#P19)";
		argument = argument+";";
		argument = argument+"P6:SmartRobotStrictLivenes.RobotAgent(2,3,1,0,6#P1#P2#P3#P4#P5#P7#P8#P9#P10#P11#P12#P13#P14#P15#P16#P17#P18#P19)";
		argument = argument+";";
		argument = argument+"P7:SmartRobotStrictLivenes.RobotAgent(2,4,2,0,7#P1#P2#P3#P4#P5#P6#P8#P9#P10#P11#P12#P13#P14#P15#P16#P17#P18#P19)";
		argument = argument+";";
		argument = argument+"P8:SmartRobotStrictLivenes.RobotAgent(3,2,3,0,8#P1#P2#P3#P4#P5#P6#P7#P9#P10#P11#P12#P13#P14#P15#P16#P17#P18#P19)";
		argument = argument+";";
		argument = argument+"P9:SmartRobotStrictLivenes.RobotAgent(3,3,4,0,9#P1#P2#P3#P4#P5#P6#P7#P8#P10#P11#P12#P13#P14#P15#P16#P17#P18#P19)";
		argument = argument+";";
		argument = argument+"P10:SmartRobotStrictLivenes.RobotAgent(3,4,4,1,10#P1#P2#P3#P4#P5#P6#P7#P8#P9#P11#P12#P13#P14#P15#P16#P17#P18#P19)";
		argument = argument+";";
		argument = argument+"P11:SmartRobotStrictLivenes.RobotAgent(4,0,4,2,11#P1#P2#P3#P4#P5#P6#P7#P8#P9#P10#P12#P13#P14#P15#P16#P17#P18#P19)";
		argument = argument+";";
		argument = argument+"P12:SmartRobotStrictLivenes.RobotAgent(4,1,4,3,12#P1#P2#P3#P4#P5#P6#P7#P8#P9#P10#P11#P13#P14#P15#P16#P17#P18#P19)";
		argument = argument+";";
		argument = argument+"P13:SmartRobotStrictLivenes.RobotAgent(4,2,4,4,13#P1#P2#P3#P4#P5#P6#P7#P8#P9#P10#P11#P12#P14#P15#P16#P17#P18#P19)";
		argument = argument+";";
		argument = argument+"P14:SmartRobotStrictLivenes.RobotAgent(0,0,1,4,14#P1#P2#P3#P4#P5#P6#P7#P8#P9#P10#P11#P12#P13#P15#P16#P17#P18#P19)";
		argument = argument+";";
		argument = argument+"P15:SmartRobotStrictLivenes.RobotAgent(4,3,2,4,15#P1#P2#P3#P4#P5#P6#P7#P8#P9#P10#P11#P12#P13#P14#P16#P17#P18#P19)";
		argument = argument+";";
		argument = argument+"P16:SmartRobotStrictLivenes.RobotAgent(4,4,3,4,16#P1#P2#P3#P4#P5#P6#P7#P8#P9#P10#P11#P12#P13#P14#P15#P17#P18#P19)";
		argument = argument+";";
		argument = argument+"P17:SmartRobotStrictLivenes.RobotAgent(0,1,2,1,17#P1#P2#P3#P4#P5#P6#P7#P8#P9#P10#P11#P12#P13#P14#P15#P16#P18#P19)";
		argument = argument+";";
		argument = argument+"P18:SmartRobotStrictLivenes.RobotAgent(0,2,2,3,18#P1#P2#P3#P4#P5#P6#P7#P8#P9#P10#P11#P12#P13#P14#P15#P16#P17#P19)";
		argument = argument+";";
		argument = argument+"P19:SmartRobotStrictLivenes.RobotAgent(0,3,1,2,19#P1#P2#P3#P4#P5#P6#P7#P8#P9#P10#P11#P12#P13#P14#P15#P16#P17#P18)";
		*/

		// Exemple de 20 robots: Après 1h30mn il n'a pas conversgé
		/*
		argument = argument+"P1:SmartRobotStrictLivenes.RobotAgent(1,1,0,0,1#P2#P3#P4#P5#P6#P7#P8#P9#P10#P11#P12#P13#P14#P15#P16#P17#P18#P19#P20)";
		argument = argument+";";
		argument = argument+"P2:SmartRobotStrictLivenes.RobotAgent(1,2,0,1,2#P1#P3#P4#P5#P6#P7#P8#P9#P10#P11#P12#P13#P14#P15#P16#P17#P18#P19#P20)";
		argument = argument+";";
		argument = argument+"P3:SmartRobotStrictLivenes.RobotAgent(1,3,0,2,3#P1#P2#P4#P5#P6#P7#P8#P9#P10#P11#P12#P13#P14#P15#P16#P17#P18#P19#P20)";
		argument = argument+";";
		argument = argument+"P4:SmartRobotStrictLivenes.RobotAgent(1,4,0,3,4#P1#P2#P3#P5#P6#P7#P8#P9#P10#P11#P12#P13#P14#P15#P16#P17#P18#P19#P20)";
		argument = argument+";";
		argument = argument+"P5:SmartRobotStrictLivenes.RobotAgent(2,2,0,4,5#P1#P2#P3#P4#P6#P7#P8#P9#P10#P11#P12#P13#P14#P15#P16#P17#P18#P19#P20)";
		argument = argument+";";
		argument = argument+"P6:SmartRobotStrictLivenes.RobotAgent(2,3,1,0,6#P1#P2#P3#P4#P5#P7#P8#P9#P10#P11#P12#P13#P14#P15#P16#P17#P18#P19#P20)";
		argument = argument+";";
		argument = argument+"P7:SmartRobotStrictLivenes.RobotAgent(2,4,2,0,7#P1#P2#P3#P4#P5#P6#P8#P9#P10#P11#P12#P13#P14#P15#P16#P17#P18#P19#P20)";
		argument = argument+";";
		argument = argument+"P8:SmartRobotStrictLivenes.RobotAgent(3,2,3,0,8#P1#P2#P3#P4#P5#P6#P7#P9#P10#P11#P12#P13#P14#P15#P16#P17#P18#P19#P20)";
		argument = argument+";";
		argument = argument+"P9:SmartRobotStrictLivenes.RobotAgent(3,3,4,0,9#P1#P2#P3#P4#P5#P6#P7#P8#P10#P11#P12#P13#P14#P15#P16#P17#P18#P19#P20)";
		argument = argument+";";
		argument = argument+"P10:SmartRobotStrictLivenes.RobotAgent(3,4,4,1,10#P1#P2#P3#P4#P5#P6#P7#P8#P9#P11#P12#P13#P14#P15#P16#P17#P18#P19#P20)";
		argument = argument+";";
		argument = argument+"P11:SmartRobotStrictLivenes.RobotAgent(4,0,4,2,11#P1#P2#P3#P4#P5#P6#P7#P8#P9#P10#P12#P13#P14#P15#P16#P17#P18#P19#P20)";
		argument = argument+";";
		argument = argument+"P12:SmartRobotStrictLivenes.RobotAgent(4,1,4,3,12#P1#P2#P3#P4#P5#P6#P7#P8#P9#P10#P11#P13#P14#P15#P16#P17#P18#P19#P20)";
		argument = argument+";";
		argument = argument+"P13:SmartRobotStrictLivenes.RobotAgent(4,2,4,4,13#P1#P2#P3#P4#P5#P6#P7#P8#P9#P10#P11#P12#P14#P15#P16#P17#P18#P19#P20)";
		argument = argument+";";
		argument = argument+"P14:SmartRobotStrictLivenes.RobotAgent(0,0,1,4,14#P1#P2#P3#P4#P5#P6#P7#P8#P9#P10#P11#P12#P13#P15#P16#P17#P18#P19#P20)";
		argument = argument+";";
		argument = argument+"P15:SmartRobotStrictLivenes.RobotAgent(4,3,2,4,15#P1#P2#P3#P4#P5#P6#P7#P8#P9#P10#P11#P12#P13#P14#P16#P17#P18#P19#P20)";
		argument = argument+";";
		argument = argument+"P16:SmartRobotStrictLivenes.RobotAgent(4,4,3,4,16#P1#P2#P3#P4#P5#P6#P7#P8#P9#P10#P11#P12#P13#P14#P15#P17#P18#P19#P20)";
		argument = argument+";";
		argument = argument+"P17:SmartRobotStrictLivenes.RobotAgent(0,1,2,1,17#P1#P2#P3#P4#P5#P6#P7#P8#P9#P10#P11#P12#P13#P14#P15#P16#P18#P19#P20)";
		argument = argument+";";
		argument = argument+"P18:SmartRobotStrictLivenes.RobotAgent(0,2,2,3,18#P1#P2#P3#P4#P5#P6#P7#P8#P9#P10#P11#P12#P13#P14#P15#P16#P17#P19#P20)";
		argument = argument+";";
		argument = argument+"P19:SmartRobotStrictLivenes.RobotAgent(0,3,1,2,19#P1#P2#P3#P4#P5#P6#P7#P8#P9#P10#P11#P12#P13#P14#P15#P16#P17#P18#P20)";
		argument = argument+";";
		argument = argument+"P20:SmartRobotStrictLivenes.RobotAgent(0,4,3,2,20#P1#P2#P3#P4#P5#P6#P7#P8#P9#P10#P11#P12#P13#P14#P15#P16#P17#P18#P19)";
		*/


	    commande [0]="-cp";
		commande [1]="jade.boot";
		commande [2]= argument;
		jade.Boot.main(commande);

		grid = new CoreControl.Grid();
		grid.colorRoadMap();
	}

}
