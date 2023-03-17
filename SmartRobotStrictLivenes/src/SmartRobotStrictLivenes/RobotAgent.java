package SmartRobotStrictLivenes;

import jade.core.*;
import jade.lang.acl.ACLMessage;
import jade.core.behaviours.*;

import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

import static SmartRobotStrictLivenes.RobotMain.grid;

public class RobotAgent extends Agent {
	int h, l;
	int x, y, myRequestedX, myRequestedY, myGoalX, myGoalY;
	int H = 0;
	int numDirection = 0;
	int nbrRequeteRefusees = 0;
	int nbrRequeteRecues = 0;
	volatile int last, NbrSites, NbrPermissionRequises;
	volatile boolean priorite, destinationAtteinte, rerequest;
	String[] R;
	String etat;

	public class SectionRestante extends OneShotBehaviour {

		@Override
		public void action() {
			// TODO Auto-generated method stub
			etat = "Dehors";
			prochainePosition();

		} // action

		public int onEnd() {
			int valTransition;
			if (destinationAtteinte) {
				valTransition = 0;
				etat = "Dedans";
			} else {
				valTransition = 1;
			}
			return valTransition;
		}
	} // SectionRestante Class

	public class AcqueRir extends OneShotBehaviour {

		@Override
		public void action() {
			// TODO Auto-generated method stub
			H++;
			last = H;
			etat = "Demandeur";
			NbrPermissionRequises = (R.length - 1);
			ACLMessage message = new ACLMessage(ACLMessage.REQUEST);
			for (int i = 1; i < R.length; i++) {
				message.addReceiver(new AID(R[i], AID.ISLOCALNAME));
			}
			message.setContent("Request" + "#" + last + "#" + R[0] + "#" + myRequestedX + "#" + myRequestedY);
			send(message);
		} // action
	} // SectionRestante Class

	public class RecPermissions extends OneShotBehaviour {

		@Override
		public void action() {
			// TODO Auto-generated method stub
			block(100);
		} // action

		public int onEnd() {
			int valTransition;
			if (rerequest) {
				System.out.println("Je suis l'agent : " + getLocalName() + " je change de direction");
				changerDirection();
				rerequest = false;
				valTransition = 2;
			} else 	if (NbrPermissionRequises == 0) {
				valTransition = 1;
			} else {
				valTransition = 0;
			}
			return valTransition;
		}
	} // RecPermissions Class

	public class SectionCritique extends OneShotBehaviour {

		@Override
		public void action() {
			// TODO Auto-generated method stub
			etat = "Dedans";
			grid.switchOffCell(x,y);
			x = myRequestedX; // La section critique signifie le déplacement du robot à la nouvelle position
			y = myRequestedY;
			grid.switchOnCell(x,y);
		} // action
	} // SectionRestante Class

	public class Liberer extends OneShotBehaviour {
		@Override
		public void action() {
			// TODO Auto-generated method stub
			etat = "Dehors";
		} // action
	} // SectionRestante Class

	public class DestinationAtteinte extends OneShotBehaviour {

		@Override
		public void action() {
			// TODO Auto-generated method stub
			block(100);
		} // action

		public int onEnd() {
			int valTransition;
			if ( (nbrRequeteRefusees == 10) || (nbrRequeteRecues == 15)) {
				changerDirection();
				destinationAtteinte = false;
				nbrRequeteRefusees = 0;
				nbrRequeteRecues = 0;
				valTransition = 1;
			}  else {
				valTransition = 0;
			}
			return valTransition;
		}
	} // DestinationAtteinte Class

	public class ReceptionMessage extends CyclicBehaviour {
		@Override
		public void action() {
			// TODO Auto-generated method stub
			ACLMessage msgRecu = receive();
			if (msgRecu != null) {
				String msgContenu = msgRecu.getContent();
				String[] tab_mess = msgContenu.split("#");
				String typemessage = tab_mess[0];
				int estampille = Integer.parseInt(tab_mess[1]);
				int requesterID = Integer.parseInt(tab_mess[2]);

				if (typemessage.equals("Request")) {
					int requesterX = Integer.parseInt(tab_mess[3]);
					int requesterY = Integer.parseInt(tab_mess[4]);
					if (destinationAtteinte) nbrRequeteRecues++;
					H = Math.max(estampille, H);
						if ( !compatible(x, y, requesterX, requesterY) ) priorite = true;
						else if (etat.equals("Demandeur"))
								if (compatible(myRequestedX, myRequestedY, requesterX, requesterY)) priorite = false;
								else if (( (last < estampille) || ((last == estampille) && (Integer.parseInt(R[0]) < requesterID)))) priorite = true;
								     else priorite = false;
							else priorite = false;
							ACLMessage message = new ACLMessage(ACLMessage.INFORM);
							message.addReceiver(msgRecu.getSender());
							if (priorite) {
								message.setContent("PermissionRefused" + "#" + estampille + "#" + R[0]);
								if (destinationAtteinte) nbrRequeteRefusees++;
							}
							else message.setContent("Permission" + "#" + estampille + "#" + R[0]);
							send(message);
				} else if (typemessage.equals("Permission")) {
					if (last == estampille) {
						NbrPermissionRequises--;
						System.out.println("Je suis l'agent : " + getLocalName() + " j'ai reçu une permission de "+ msgRecu.getSender().getLocalName()
								+ " Nombre de permission restantes est "+ NbrPermissionRequises);
					}
				} else rerequest = true;
			}
		} // action
	} // ReceptionMessage Class

	public void prochainePosition() {
		if (!destinationAtteinte) {
			if (x < myGoalX) {
				myRequestedX = x + 1;
				myRequestedY = y;
			} else if (x == myGoalX) {
				myRequestedX = x;
				if (y < myGoalY) {
					myRequestedY = y + 1;
				} else if (y > myGoalY) {
					myRequestedY = y - 1;
				} else if (y == myGoalY) {
					destinationAtteinte = true;
					nbrRequeteRefusees = 0;
					System.out.println(
							"Je suis l'agent : " + getLocalName() + " je suis arrivé à destination ( " + x + "," + y + ")");
				}
			} else if (x > myGoalX) {
				myRequestedX = x - 1;
				myRequestedY = y;
			}
		}
	}

	public void changerDirection() {
		boolean deplacementPossible = false;
		while (!deplacementPossible){
			//int d = (int) (Math.random() * 4);
			numDirection = ((numDirection + 1)%4);
			switch (numDirection) {
				case 0: {
					deplacementPossible = deplacerEst();
					break;
				}
				case 1: {
					deplacementPossible = deplacerSud();
					break;
				}
				case 2: {
					deplacementPossible = deplacerOuest();
					break;
				}
				default: {
					deplacementPossible = deplacerNord();
				}
			}
		}
	}

	public boolean deplacerEst() {
		if (x < l-1) {
			myRequestedX = x + 1;
			myRequestedY = y;
			return true;
		} else return false;
	}

	public boolean deplacerOuest() {
		if (x > 0) {
			myRequestedX = x - 1;
			myRequestedY = y;
			return true;
		} else return false;
	}

	public boolean deplacerNord() {
		if (y > 0) {
			myRequestedY = y - 1;
			myRequestedX = x;
			return true;
		} else return false;
	}

	public boolean deplacerSud() {
		if (y < h-1) {
			myRequestedY = y + 1;
			myRequestedX = x;
			return true;
		} else return false;
	}

	public boolean compatible(int x, int y, int requestedX, int requestedY) {
		return (!(x == requestedX) || !(y == requestedY));
	}

	protected void setup() {
		Object[] args = getArguments();
		if (args != null) {
			h = 5;
			l = 5;
			myGoalX = Integer.parseInt((String) args[2]);
			myGoalY = Integer.parseInt((String) args[3]);
			R = args[4].toString().split("#");
			x = Integer.parseInt((String) args[0]);
			y = Integer.parseInt((String) args[1]);
			destinationAtteinte = ( (x == myGoalX) && (y == myGoalY));
			System.out.println(
					"Je suis l'agent : " + getLocalName() + " je suis à ( " + x + "," + y + ") ma destination est ("+ myGoalX + "," + myGoalY + ")");
			rerequest = false;

			etat = "dehors";
			NbrSites = (R.length - 1);

			if (l <= 0) {
				throw new IllegalArgumentException("La largeur doit être un nombre entier positif");
			}

			if (h <= 0) {
				throw new IllegalArgumentException("La longueur doit être un nombre entier positif");
			}

			if ((myGoalX < 0) || (myGoalX > l-1)) {
				throw new IllegalArgumentException(
						"La position finale du robot sur la largeur doit être dans l'interval [0," + l + " [");
			}

			if ((myGoalY < 0) || (myGoalY > h-1)) {
				throw new IllegalArgumentException(
						"La position finale du robot sur la longueur doit être dans l'interval [0," + h + "[");
			}

			grid.switchOnCell(x,y);

			for (int i = 0; i < R.length; i++) {
				System.out.println(R[i]);
			}

			// Ajouter le comportement
			ParallelBehaviour ProcessBehaviour = new ParallelBehaviour(ParallelBehaviour.WHEN_ALL);
			FSMBehaviour myBehaviour = new FSMBehaviour(this);

			// Ajouter les états
			myBehaviour.registerFirstState(new SectionRestante(), "Dehors");
			myBehaviour.registerState(new AcqueRir(), "Demandeur");
			myBehaviour.registerState(new RecPermissions(), "DemandeurAttentePermissions");
			myBehaviour.registerState(new SectionCritique(), "Dedans");
			myBehaviour.registerState(new Liberer(), "VersDehors");
			myBehaviour.registerState(new DestinationAtteinte(), "DestinationAtteinte");

			// Ajouter les transitions
			myBehaviour.registerTransition("Dehors", "DestinationAtteinte", 0);
			myBehaviour.registerTransition("Dehors", "Demandeur", 1);
			myBehaviour.registerDefaultTransition("Demandeur", "DemandeurAttentePermissions");
			myBehaviour.registerTransition("DemandeurAttentePermissions", "DemandeurAttentePermissions", 0);
			myBehaviour.registerTransition("DemandeurAttentePermissions", "Dedans", 1);
			myBehaviour.registerTransition("DemandeurAttentePermissions", "Demandeur", 2);
			myBehaviour.registerDefaultTransition("Dedans", "VersDehors");
			myBehaviour.registerDefaultTransition("VersDehors", "Dehors");
			myBehaviour.registerTransition("DestinationAtteinte", "DestinationAtteinte", 0);
			myBehaviour.registerTransition("DestinationAtteinte", "Demandeur", 1);

			ProcessBehaviour.addSubBehaviour(myBehaviour);
			ProcessBehaviour.addSubBehaviour(new ReceptionMessage());
			addBehaviour(myBehaviour);
			addBehaviour(ProcessBehaviour);
			// Start();
		}
		// addBehaviour(new Cycrobot());
	}
}