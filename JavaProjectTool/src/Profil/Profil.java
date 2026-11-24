package Profil;

import java.awt.Font;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import AssetManager.Asset;
import Core.Core;
import EventManager.ProfilEvent;
import SceneComponent.*;

public class Profil 
{
	private Core core;
	private ProfilEvent eventManager;
	public SceneComponent currentScene;
	
	public String name;
	public String grade;
	
	private SceneComponent sceneIllustration;
	private SceneComponent sceneStatistique;
	private SceneComponent scenePdp;
	
	// Pdp ( Pdp = Photo de profil )
	public ArrayList<BufferedImage> listIm;
	private BufferedImage Pdp;
	public Sprite SpritePdp;
	public Button ButtonPdp1;
	public Button ButtonPdp2;
	
	public Profil(Core core, String name) 
	{
		this.core = core;
		this.eventManager = new ProfilEvent(this);
		this.name = name;
		SetGrade(core.topLvl);
		
		// Default Pdp
		this.listIm = new ArrayList<BufferedImage>();
		SetListImage();
		
		this.Pdp = listIm.get(0);
		
		this.sceneIllustration = new SceneComponent();
		this.sceneStatistique = new SceneComponent();
		this.scenePdp = new SceneComponent();
		SetIllustrationScene();
		SetStatistiqueScene();
		SetPdpScene();
		
		currentScene = sceneIllustration;
	}

	private void SetGrade(int TopLevel) 
	{
		if(TopLevel < 0)
			this.grade = "Tricheur";
		
		else if(TopLevel < 5)
			this.grade = "Débutant";
		
		
		else
			this.grade = "PôleEmploie";
		
	}
	
	private void SetListImage() {
		listIm.add(Asset.GetIm("F1"));
		listIm.add(Asset.GetIm("F2"));
	}
	
	/*
	 * Scene Creation
	 */
	private void SetIllustrationScene() 
	{
		// Button
		ButtonPdp1 = new Button(new Point(50,50), 200, 200, Pdp);
		ButtonPdp1.AddEvent(eventManager.SwitchCurrentScene(sceneStatistique));
		sceneIllustration.button.add(ButtonPdp1);
		
	}
	
	private void SetStatistiqueScene() 
	{
		// Sprite
		sceneStatistique.sprite.add(new Sprite(new Point(0,0), 300, 300, Asset.GetIm("Yellow")));
		
		// Button
		Button bX = new Button(new Point(0,0), 50, 30, "X");
		bX.AddEvent(eventManager.SwitchCurrentScene(sceneIllustration));
		sceneStatistique.button.add(bX);
		
		ButtonPdp2 = new Button(new Point(175,25), 100, 100, Pdp);
		ButtonPdp2.AddEvent(eventManager.SwitchCurrentScene(scenePdp));
		sceneStatistique.button.add(ButtonPdp2);
		
		// Label
		sceneStatistique.label.add(new Label(new Point(10,40), "Name : " + name, new Font("Arial", Font.PLAIN, 20)));
		sceneStatistique.label.add(new Label(new Point(10,70), "Grade : " + grade, new Font("Arial", Font.PLAIN, 20)));
		sceneStatistique.label.add(new Label(new Point(10,100), "Hight Level : " + core.topLvl, new Font("Arial", Font.PLAIN, 20)));
		sceneStatistique.label.add(new Label(new Point(10,130), "Description", new Font("Arial", Font.PLAIN, 20)));
		
		// Text
		sceneStatistique.text.add(new TextArea(new Point(10,155), 280, 125, ""));
	}
	
	private void SetPdpScene() {
		// Sprite
		SpritePdp = new Sprite(new Point(70,50), 160, 160, Pdp);
		
		scenePdp.sprite.add(new Sprite(new Point(0,0), 300, 300, Asset.GetIm("Yellow")));
		scenePdp.sprite.add(SpritePdp);
		
		// Button
		Button bX = new Button(new Point(0,0), 50, 30, "X");
		bX.AddEvent(eventManager.SwitchCurrentScene(sceneStatistique));
		scenePdp.button.add(bX);
		
		Button bLeft = new Button(new Point(10,120), 50, 50, "<");
		Button bRight = new Button(new Point(240,120), 50, 50, ">");
		bLeft.AddEvent(eventManager.SwitchPdp(false));
		bRight.AddEvent(eventManager.SwitchPdp(true));
		scenePdp.button.add(bLeft);
		scenePdp.button.add(bRight);
	}
	
}
