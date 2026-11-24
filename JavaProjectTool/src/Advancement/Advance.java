package Advancement;

import SceneComponent.Button;

import java.awt.Font;
import java.awt.Point;

import AssetManager.Asset;
import Core.Core;
import EventManager.AdvanceEvent;
import SceneComponent.*;

	public class Advance 
	{
		private Core core;
		private AdvanceEvent eventManager;
		public SceneComponent scene;
		
		public int score;
		public Label scoreLabel;
		
		public Advance(Core core) 
		{
			this.core = core;
			eventManager = new AdvanceEvent(this);
			scene = new SceneComponent();
			
			this.score = 0;

			SetScene();
		}
		
		private void SetScene() 
		{
			// Sprite
			scene.sprite.add(new Sprite(new Point(0,0), 300, 1000, Asset.GetIm("Blue")));
			
			// Button
			Button b = new Button(new Point(100,500), 100, 50, Asset.GetIm("F1"));
			b.AddEvent(eventManager.ChangeScore(10));
			scene.button.add(b);
			
			// Label
			this.scoreLabel = new Label(new Point(120,600), String.valueOf(score), new Font("Arial", Font.BOLD, 80));
			
			scene.label.add(new Label(new Point(80,450), "Ajouter 10 Points", new Font("Arial", Font.PLAIN, 20)));
			scene.label.add(scoreLabel);
		}
		
	}
