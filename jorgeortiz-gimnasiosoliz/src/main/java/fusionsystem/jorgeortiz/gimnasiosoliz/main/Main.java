package fusionsystem.jorgeortiz.gimnasiosoliz.main;

import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

import fusionsystem.jorgeortiz.gimnasiosoliz.util.Sonido;
import fusionsystem.jorgeortiz.gimnasiosoliz.util.UbicacionArchivo;

//import fusionsystem.jorgeortiz.gimnasiosoliz.service.CorreoGmailService;

public class Main {

	public static void main(String[] args) {

		Clip sound = Sonido.getSound("ok.wav");
		Sonido.playSound(sound);
		
		
	}
	

}
