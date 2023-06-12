import com.sun.j3d.utils.universe.SimpleUniverse;

import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.io.FileReader;

import com.sun.j3d.loaders.Scene;
import com.sun.j3d.loaders.objectfile.ObjectFile;
import com.sun.j3d.utils.behaviors.vp.OrbitBehavior;
import com.sun.j3d.utils.geometry.Box;
import com.sun.j3d.utils.geometry.Primitive;

import javax.media.j3d.Appearance;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.Material;

import javax.vecmath.Color3f;
import javax.vecmath.Vector3d;

public class ModelCalc extends JFrame {
    private SimpleUniverse universe;
    private TransformGroup modelTransformGroup;
    private Canvas3D canvas3D;

    public ModelCalc() {
        super("Model Slicer");

        // Erstellen Sie eine GraphicsConfiguration, um das Canvas 3D zu erstellen
        GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();

        // Erstellen Sie ein Canvas3D-Objekt und fügen Sie es zum Frame hinzu
        canvas3D = new Canvas3D(config);
        getContentPane().add(canvas3D, BorderLayout.CENTER);

        // Erstellen Sie das SimpleUniverse-Objekt und rufen Sie die ViewPlatform ab
        universe = new SimpleUniverse(canvas3D);
        BranchGroup scene = createSceneGraph();
        universe.getViewingPlatform().setNominalViewingTransform();

        // Fügen Sie die Szene zum SimpleUniverse hinzu
        universe.addBranchGraph(scene);

        // Konfigurieren Sie das JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setVisible(true);
    }

    private ObjectFile getLoader() {
        ObjectFile loader = new ObjectFile(ObjectFile.RESIZE);
        loader.setFlags(ObjectFile.RESIZE | ObjectFile.TRIANGULATE | ObjectFile.STRIPIFY);
        return loader;
    }

    private Scene loadModel(String modelPath) throws Exception {
        ObjectFile loader = getLoader();
        return loader.load(new FileReader(modelPath));
    }

    private BranchGroup createSceneGraph() {
        BranchGroup root = new BranchGroup();

        // Erstellen Sie die TransformGroup für das Modell
        modelTransformGroup = new TransformGroup();
        modelTransformGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        root.addChild(modelTransformGroup);

        // Laden Sie das Modell aus dem "Models"-Ordner
        String modelPath = "Models/Sortierung_Verbinder.stl"; // Passe den Dateipfad an
        Scene modelScene = null;
        try {
            modelScene = loadModel(modelPath);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Fügen Sie das Modell zur TransformGroup hinzu
        if (modelScene != null) {
            modelTransformGroup.addChild(modelScene.getSceneGroup());
        }

        // Erstellen Sie das 2D-Gitter
        int gridSize = 400;
        TransformGroup gridTransformGroup = createGridTransformGroup(gridSize);
        root.addChild(gridTransformGroup);

        // Erstellen Sie das Verhalten für die Kamerasteuerung
        OrbitBehavior orbitBehavior = new OrbitBehavior(canvas3D, OrbitBehavior.REVERSE_ALL);
        orbitBehavior.setSchedulingBounds(new BoundingSphere());
        universe.getViewingPlatform().setViewPlatformBehavior(orbitBehavior);

        return root;
    }

    private TransformGroup createGridTransformGroup(int gridSize) {
        TransformGroup transformGroup = new TransformGroup();

        // Erstellen Sie das 2D-Gitter
        Appearance gridAppearance = new Appearance();
        Color3f gridColor = new Color3f(0.7f, 0.7f, 0.7f);
        Color3f emissiveColor = new Color3f(0.0f, 0.0f, 0.0f);
        Material gridMaterial = new Material(gridColor, emissiveColor, gridColor, emissiveColor, 100.0f);
        gridAppearance.setMaterial(gridMaterial);

        int numLines = 21;
        float lineSpacing = (float) gridSize / (numLines - 1);

        for (int i = 0; i < numLines; i++) {
            float yPos = -gridSize / 2 + i * lineSpacing;
            Box lineX = new Box(gridSize, 0.1f, 0.1f, Primitive.GENERATE_NORMALS, gridAppearance);
            Box lineY = new Box(0.1f, 0.1f, gridSize, Primitive.GENERATE_NORMALS, gridAppearance);

            Transform3D lineXTransform = new Transform3D();
            lineXTransform.setTranslation(new Vector3d(0, yPos, 0));
            TransformGroup lineXTransformGroup = new TransformGroup(lineXTransform);
            lineXTransformGroup.addChild(lineX);

            Transform3D lineYTransform = new Transform3D();
            lineYTransform.setTranslation(new Vector3d(0, yPos, 0));
            TransformGroup lineYTransformGroup = new TransformGroup(lineYTransform);
            lineYTransformGroup.addChild(lineY);

            transformGroup.addChild(lineXTransformGroup);
            transformGroup.addChild(lineYTransformGroup);
        }

        return transformGroup;
    }

    public static void main(String[] args) {
        new ModelCalc();
    }
}