package gui;

	import java.awt.BorderLayout;
	import java.awt.Color;
	import java.awt.Dimension;
	import java.awt.Image;
	import java.awt.Toolkit;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.awt.Image;

	import javax.swing.ImageIcon;
	import javax.swing.JButton;
	import javax.swing.JFrame;
import javax.swing.JLabel;
	
public class GUI_Crear_Planeta extends JFrame {
	
//	static final String[] listadoPosiblesNombresPlanetas = {"Largeleaf Maidenhair","Chiricahua Mountain Mock Vervain","Mearns' Mock Orange","Pricklyfruit Bur Cucumber","Cup Lichen","Yellow Jacob's-ladder","Silverleaf Ponysfoot","Lady Of The Night Orchid","Rabbitsfoot Grass","Chinese Clubmoss","Roughfruit Fairybells","Nelson's Brachythecium Moss","Nightblooming Cereus","Oregon Gumweed","Centerville Brazos-mint","Pt. Reyes Bird's-beak","Purple Milkwort","Macoun's Woodroot","Richardson's Needlegrass","Redberry Nightshade","Santa Barbara Spineflower","Hanaupah Rockdaisy","American Aspicilia","Nootka Cypress","Beard Lichen","Rocky Mountain Pussytoes","Standley's Spikemoss","Florida Hobblebush","Lindbergia Moss","Great Basin Springbeauty","Rue Anemone","Rhizome Bluegrass","Fall Tansyaster","Mexican Orange","Guadalupe Wild Coffee","Mountain Pepperweed","St. Lawrence Dewberry","Green Hawthorn","Velvet Bean","Timothy","Parish's Oxytheca","Gummy Lovegrass","Honeysweet","Oahu Flatsedge","Red Huckleberry","Seaside Brookweed","Variable Linanthus","Greenland Orange Lichen","Texas Bedstraw","Disjuct Melanelia Lichen","Pajaro Manzanita","Field Sagewort","Pointtip Twinpod","Sweet Basil","Phlox Heliotrope","Arctic Spotted Felt Lichen","New Mexico Groundsel","Svenson's Beggarticks","Racemose Phacelia","Chamisso Arnica","Narrowleaf Purple Everlasting","Tussock Paspalum","Byssoloma Lichen","Cartilage Lichen","Bracted Passionflower","Longleaf Cyrtandra","Cochise Horseweed","Sodaville Milkvetch","Whitewhorl Lupine","Pestilence Wort","Brazilian Bristlegrass","Stigmidium Lichen","Bolander's Mule-ears","American Century Plant","Curvedleaf Stonecrop","Western Willow Dock","Largeflower Tickseed","Henry's Spiderlily","Lipfern","Grasspink","Robbins' Pondweed","Gland Onion","Common Gypsyweed","Nipplebract Arrowhead","Narrowleaf Midsorus Fern","Ballhead Waterleaf","Eared Rockcress","Piper's Buxbaumia Moss","Wart Lichen","Galearis","Xanthoparmelia Lichen","Browallia","Byron Larkspur","Coastal Brookfoam","Mangrove","Trichosanthes","Eastern Milkpea","Birdcage Evening Primrose","Atrichum Moss","Texas Desert-thorn","Sierra Madre St. Johnswort","Delicate Arctomia Lichen","Polynesian Heliotrope","Shortstem Buckwheat","Limpleaf Spikemoss","Lesser Meadow-rue","Needle Lichen","Tuckerman's Earth Lichen","Lyon's Hacksaw Fern","Greater Yellowthroat Gilia","Hoary Balsamroot","Cory's Croton","Cornish Heath","Toadflax","Rhodotypos","Whortleberry","Parishella","Yellow Mignonette","Mountain Blue-eyed Grass","False Buffalograss","Broom","Port Orford Cedar","Lecidella Lichen","Porpidia Lichen","Narrow-leaved Rockdaisy","Balloon Sack Clover","Quillwort Arrowhead","Roadside Toadflax","Vente Conmigo","Pinyon Lupine","Hawai'i 'ohe","Zamia","Harbinger Of Spring","Farkleberry","Turk's Cap","Olopu","Rosary Babybonnets","Detling's Silverpuffs","Southern Suncup","Wildrye","White Marsh Marigold","Field Sagewort","Mahua","Littlecup Beardtongue","Clammy Groundcherry","Small Spikerush","Tuftedstem Rush","Cochlear Cartilage Lichen","Yellow Wakerobin","Roundleaf Buffaloberry","Oneflower Fleabane","California Indigobush","Eggyolk Lichen","Pitted Onion","Stiff Blue-eyed Grass","Common Flax","Tall Blazing Star","Cracked Lichen","Leafy Bladderwort","Sturt's Cassia","Toothleaf","Tall Coastal Plantain","Chicory","Cylinder Spikerush","Florida Alicia","Giant Sandbur","Hachuela","Largeroot Morning-glory","Eschscholtz's Buttercup","Royal Star Orchid","Verity's Liveforever","Davidson's Saltbush","Cymophora","Lotus Sweetjuice","Coldwater Fumewort","Creeping Milkvetch","Tailed Hollyfern","Humboldt Wallflower","Flax Dodder","Saw-wort","Tree Anemone","'awiwi","Rimmed Lichen","Desert Ceanothus","Subalpine Fleabane","White Cypress-pine","Macvaugh's Dewberry","Woolly Senna","Hawthorn","Clubmoss Mountain Heather","Whited's Fissurewort","Threeparted Miterwort","Fourflower Yellow Loosestrife","Amblystegium Moss","Fringed Amaranth","Sleepydaisy","Shortleaf Small Limestone Moss","Poranopsis","Glypholecia Lichen","Phlox Heliotrope","Hoffmann's Teddybear Cholla","Scarlet-plume","Shortleaf Lobelia","Hairy Braya","Torch Tree","Littleleaf Mock Orange","Jones' Pitcherplant","California Stoneseed","California Yerba Santa","Porterella","Adam And Eve","Pleurocoronis","Thurber's Buckwheat","Squarrose Sedge","Mountain Monardella","Arana","Carrotwood","Damask Rose","Eared Flatsedge","Fragrant White Sand Verbena","Dotted Orchid","Sclerocarya","Vreeland's Erigeron","Membranous Garlicvine","Rim Lichen","Spring Lady's Tresses","Douglas' Monardella","Carolina Thelomma Lichen","Lemmon's Wildginger","Hammond's Claytonia","Strawberry","Laurel Amarillo","Elegant Piperia","Warnock's Ragwort","Leucolepis Umbrella Moss","Bastard Stopper","Sphagnum Absonditella Lichen","Whiteflower Cinquefoil","Northern Dandelion","St. Thomas Lidpod","Bog Clermontia","Disc Lichen","Alpine Rose","Java Plum","Gorman's Dwarf-primrose","Limestone Violet","Vavilov's Wheat","Saline Valley Phacelia","Pandanus","Raiche's Clarkia","Elongate Pohlia Moss","Tapertip False Wheatgrass","Black Locust","Constance's Bittercress","Sandhill Thistle","Oppositeleaf Maiden Fern","Stink Currant","Merriam's Alumroot","Slender-spire Orchid","Wart Lichen","Carpet Phlox","Cutleaf Silverpuffs","Arizona Cudweed","Dot Lichen","Hedgehyssop","Copaifera","Navajo Mountain Beardtongue","South Idaho Onion","Rambling Fleabane","Pale Botrychium","Hawai'i Lady's Nightcap","Thicksepal Cryptantha","Firebush","Atkinson's Tickseed","Compassplant","River Teatree","Osterhout's Cryptantha","Waianae Range Alsinidendron","Holozonia","Kokee Stream Melicope","Eightpetal Mountain-avens","Tortured Horsehair Lichen","Turgid Aulacomnium Moss","Mink Hawthorn","Nodding Chickweed","Amur Grape","Gambel Oak","Slenderfruit Nutrush","Small-lobe Navarretia","Clokey's Greasebush","Russet Hedgehog Cactus","Globe Beaksedge","Carrizo Creek Globemallow","Ambiguous Aloina Moss","Shorthook Fishhook Cactus","Hedge False Bindweed","Quina","Norwegian Tortula Moss","Tall Threeawn","Showy Zephyrlily","Carolina Springbeauty","Orangefruit Horse-gentian","Mexican-blue","Mountain Babyboot Orchid","Trachybryum Moss","Threadleaf Ragwort","Gland Indian Paintbrush","Cleveland's Bush Monkeyflower","Munnik Fescue","Disc Lichen","Mississippi Hawthorn","Apodanthera","Wallaby Grass","Shortleaf Baccharis","Molokai Melicope","Vanda","Narrowleaf Silkgrass","Silver Banksia","Wood Wakerobin","Bolander's Tortula Moss","Arizona Alumroot","Mountain Sage","Wild Hydrangea","Blood-trumpet","Hawthorn","Hybrid Willow","Shaggy Crabgrass","Olokele Canyon Nehe","Dwarf Eelgrass","Burnham's Blackberry","Beadle Oak","Stalkless Yellowcress","Tundra Alkaligrass","Horsehair Lichen","Austria Timmia Moss","Oceanblue Phacelia","Fernald's Northern Rockcress","Wyman Creek Buckwheat","Jasmine Tobacco","Fringed Orchid","Polytrichastrum Moss","Mojave Cleomella","Dot Lichen","Roughstem Hawkweed","Sonoma Koerberia Lichen","Russell's Fishscale Lichen","Healing Croton","Snowy Thistle","Torrey Pine","Upright Spurge","Leucophysalis","Sarea Lichen","Savannah Fanpetals","Watson's Oxytheca","Mountain Aster","Camasey De Costilla","Palo Alto Thistle","Daisy","Netleaf Willow","Manybranched Ipomopsis","Chinese Juniper","Jelly Lichen","Western Willow Dock","Richweed","Reed Canarygrass","Asian Spiderflower","Parmotrema Lichen","Giant Purple Wakerobin","Fissidens Moss","Seaside Eryngo","Spontaneous Barley","Cup Lichen","Black Mangrove","Coastal Brookfoam","Woodland Geranium","Different-nerve Sedge","Gentian","Erythrina","Beard Lichen","California Tickseed","Orange Lichen","Stiff Blue-eyed Grass","Miriquidica Lichen","Mulford's Milkvetch","Rubberweed","Leprevost's Helminthocarpon Lichen","Sprucetop Grama","Lilacbush","Neofuscelia Lichen","Mountain Pepperweed","Eastern Daisy Fleabane","Black Booyong","Lecania Lichen","Pili Nehe","Hammock Viper's-tail","Pacific Bleeding Heart","Ash Penstemon","Hawkweed","St. John's Rollandia","Bengal Coffee","Giant Flatsedge","Wart Lichen","Sweet Shaggytuft","Winged Sandpuffs","White Prairie Rose","Alpine Spicywintergreen","Douglas' Golden Violet","Corcho Bobo","Elecampane Inula","California Lady's Slipper","Southwestern Bedstraw","Tarweed","Carson's Waterparsnip","Cerro De Punta Jayuya","Needle And Thread","Spring Coralroot","Broadleaf Lupine","Elegant Hawksbeard","Blue Maidencane","Toumey's Sundrops","Texas Palafox","Woolly Distaff Thistle","Creeping Lady's Nightcap","Dust Lichen","Hairy Corkwood","Middleton False Foxglove","Queendevil","Viper Beggarticks","Bolander's Water-starwort","Glades Spikerush","California Broomrape","Giant Filbert","Cumberland False Rosemary","Western Trailing Ticktrefoil","Sampson's Snakeroot","Smallflower Desert-chicory","Eastern Bottlebrush Grass","Bigtooth Aspen","Nakedstem Carpetweed","Giradol","Foxglove","Sterculia","Hybrid Violet","Sharsmith's Draba","California Skin Lichen","Macoun's Woodroot","Yenisei River Pondweed","Palmleaf Indian Breadroot","Pincushions","Khat","Peruvian Peppertree","Hummingbird Sage","Yellow Balsam","Woollypod Milkvetch","Torrey's Rush","Hornwort","Heliconia","Lens Pod Milkvetch","Asian Spikemoss","Havard's Fiddleleaf","Shaggy Hedgehyssop","Walter's Sedge","Las Animas Nakedwood","Western Blue Virginsbower","Isely's Stickpea","Broadkeel Milkvetch","Microcitrus","Wild Mustard","Slimleaf Drymary","Island Spleenwort","Grayleaf Phlox","Cordroot Beardtongue","Creeping Blueberry","Bipinnate Princesplume","Coyote Mint","Cocuyo","Woodland Wild Coffee","Fishtail Swordfern","Woolly Bluecurls","Chihuahuan Pine","Whorled Mountainmint","Marsh Water-willow","Calistoga Pincushionplant","Yellow Coralbells","Vetch","Southern Mountain Buckwheat","Snow Dwarf-primrose","Lemon Beebalm","Carolina Leaf-flower","Royal Fern","Campylopus Moss","Brighamia","Sedge","Lakeshore Sedge","Heartleaf Keckiella","Spike Lichen","Biennial Woollywhite","Greene's Maple","Crocynia Lichen","Billion-dollar Grass","Gypsum Milkvetch","Drummond's Aster","Smooth Woodsia","Common Hedgenettle","Tinker's Penny","Bicknell's Sedge","Flatleaf Flatsedge","Holzinger's Venus' Looking-glass","Canby's Bulrush","Red Mulberry","Solenospora Lichen","Buffalobur Nightshade","Common Motherwort","Sulphur Hot Springs Buckwheat","Menzies' Cartilage Lichen","Spiked Crinkleawn","Bearded Popcornflower","Wagner's Cyrtandra","Little Gilia","Red Spruce","Bladderwort","Tobacco Root","Showy Goldenrod","Blood Iris","Bowl Lichen","Canary Island St. Johnswort","Fuzzy Sedge","Chaparral Brodiaea","Aji","Spreading Woodfern","Greater Yellow Lady's Slipper","Oniongrass","Cutleaf Blazingstar","Annual Swordfern","Cup Lichen","Slender Mountain Sandwort","Grannyvine","Northeastern Dewberry","Limestone Meadow Sedge","Shield Lichen","Countess Dalhousie's Spleenwort","False Freesia","Alexander's Rock Aster","Forest Stenogyne","Spreading Amaranth","Eaton's Rosette Grass","Bulbothrix Lichen","Scented Senna","Michuacan Lady Orchid","Antlerfern","Black Baneberry","Shrubby False Mallow","Tiger's Claw","Northern Tansymustard","Clearwater Phlox","Dwarf Mountain Lupine","Cadaba","Rayless Mock Goldenrod","Dunedelion","Airplant","Nisperillo","Citron","Baby Blue Eyes","Milk Kelloggia","Po'ola","Small-leaf Bittercress","White Hoarypea","Rio Grande Beeblossom","Hybrid Willow","Lithophila","Coast Wallflower","Western Dock","White Moneywort","Canada Spikesedge","Sunflower","Spiny Holdback","Humboldt's Lily","Cary's Beardtongue","Soleirolia","Milk-berry","Humboldt Lily","Whitethorn Acacia","Gongolin","Clubmoss","Orcutt's Foxtail Cactus","Claspleaf Twistedstalk","Country Indian Paintbrush","White Kauai Rosemallow","Golden Crownbeard","Beautiful Bluebells","Goldenthread","Utah Mousetail","Necklace Island Spleenwort","Thunberg's Geranium","California Poppy","Tricardia","Lemon-flower Gum","Fivestamen Burbark","Bryum Moss","Woodfern","Dimple Lichen","King's Clover","Mooncarrot","Southern Mexican Sage","Upright Myrtle Spurge","Pore Lichen","Manyleaf Mousetail","Thickleaf Scaly Polypody","Cedro Macho","Nuttall's Horsebrush","Lowland Blackberry","Rusty Foxglove","Sibbaldia","Heartleaf Morning-glory","Shortstem Sedge","Husk Tomato","Roundleaf Sensitive Pea","Bornholm's Bryum Moss","Death Valley Beardtongue","Michaux's Milkweed","Dock","Telescope Peak Buckwheat","Feay's Palafox","Virginia Springbeauty","Simplebeak Ironwort","Hypnum Moss","Brachythecium Moss","Martin's Clover","Greene's Milkweed","Dubautia","Mangrove","Peak Saxifrage","Navel Lichen","South Texas Blanketflower","Noni Kuahiwi","Downy Lobelia","Ribbonleaf Pondweed","Eclipta","Narrowleaf Terciopelo","Graham's Manihot","Pinegrove Groundsmoke","African Mahogany","Showy Goldeneye","Ash Meadows Gumweed","Elegant Rockcress","Canyon Grape","Largebracted Plantain","Death Valley Sandmat","Aerialroot Bristle Fern","Floating Primrose-willow","Bluebells","Rat-tail Nipple Cactus","Monolopia","Pondweed","Aspen Onion","Broadleaf Arnica","Zion False Goldenaster","Scribner's Hawkweed","Wart Lichen","Manyflower Rush","Rockface Yellow Loosestrife","Cedar Breaks Springparsley","Trans-pecos Desert Goldenrod","Colorado Four O'clock","Elegant Indian Paintbrush","Maui Island-aster","Tubercle Dot Lichen","Bitter Yam","Orange Lichen","Tropical Lilythorn","Rice Button Aster","Baker's Manzanita","Woolly Milkweed","Grateloupia","Prairie False Foxglove","Hybrid Pitcherplant","Largeflower Tickseed","Schneck Oak","Mountain Lupine","Halberd Fern","Flor De San Jose","Shaggyfruit Pepperweed","Corn Poppy","Rincon Ridge Ceanothus","Nightshade","Zuni Milkvetch","Guazuma","Western Thelomma Lichen","Whorled Tickseed","Giant Ironweed","San Luis Obispo Coyote Mint","Bluntleaf Bedstraw","Davy's Centaury","Small Phacelia","Bell-flower Pricklypear","Rayless Goldenhead","Veiny Brickellbush","Petioled Fountaingrass","Pallas' Wallflower","Macoun's Cudweed","Makole","Cucumber Tree","Raggedlip Orchid","Appalachian Barren Strawberry","Witchhazel","Brushy Mountain St. Johnswort","Cylinder Spikerush","Freckled Milkvetch","Sierra Milkwort","Pungent Brickellbush","Star Of Bethlehem","Zion Buckwheat","Forked Green Fiddleneck","Oil Shale Columbine","Roundleaf Greenbrier","Red Cottongrass","California Seapink","Sarcogyne Lichen","Alpine Sweetgrass","Mediterranean Brome","South American Amazonvine","Silverleaf Cotoneaster","Purpleflower Pinkroot","Coconut Palm","White Indigoberry","Streambank Springbeauty","Field Locoweed","Bristlecup Sandmat","Colorado Buckwheat","Mahogany","Meesia Moss","Harford's Oniongrass","Florida Hawthorn","Yellow Wildrye","Map Lichen","Tall Silverbush","Deam's Rosinweed","Ponderosa Pine","Virginia Whitehair Leather Flower","Northern Kittentails","Southwestern Showy Sedge","Palmyra Palm","Blumer Buckthorn","Payson's Pepperweed","Dipteryx","Twistleaf Yucca","Neon Fissidens Moss","Shiny Woodoats","Bigroot Springparsley","Inyo Milkvetch","Map Lichen","Slender Scratchdaisy","Purple Cluster Geranium","Siberian Wheatgrass","Brouard's Dotted Lichen","Flatfruit Beaksedge","Longleaf Phlox","Limewater Brookweed","Hairgrass","Kellogg's Spurred Lupine","Caterpillars","Arctic Brome","Little Floating Bladderwort","Pulvinate Euopsis Lichen","Evening Rainlily","Pink Velvetmallow","Glacier Avens","Giant-trumpets","Tundra Pohlia Moss","White Beaksedge","Centratherum","White Crownbeard","Perennial Honesty","Rim Lichen","Aster","Rose Glorybower","Cherokee Sedge","Browneyes","Forest Mirrorplant","Inland Muilla","Maximowicz's Myuroclada Moss","Diamond-flowers","Sperry Guava","Forest Tetramolopium","Halifax Blackberry","Speenwort","Lead Lichen","Hamatocactus","Panoche Pepperweed","Encinitis False Willow","Sendtner's Polyplastia Lichen","Alpine Clover","Lowland Yellow Loosestrife","Santonica","Hairyfruit Valerian","Biatora Lichen","Knot Grass","Poodle-dog Bush","Western Spruce Dwarf Mistletoe","Psilopilum Moss","Lindheimer's Silktassel","Little Green Sedge","Cartilage Lichen","Ferntree","Rough Jointfir","Crabgrass","Clasping Jewelflower","Hawai'i Sedge","Sevenangle Pipewort","Indian Rosewood","Whitetop","Sleepy Silene","Creeping Muhly","Popular Buttercup","Oakleaf Garden Geranium","Star Tickseed","Padron's Stopper","Ehrenberg's Adder's-mouth Orchid","Coral Greenbrier","Sticky Oxeye","North Pacific Draba","Spiked Hoarypea","Skeletonweed","Bridges' Brodiaea","Arizona Lupine","Chestnut Rose","Rocky Mountain Indian Parsley","Jaeger's Beardtongue","Prairie Plantain","Dot Lichen","Arizona Desert Foxglove","Leiberg's Milkvetch","Wart Lichen","Delicate Arctomia Lichen","Xylographa Lichen","Stinking Hawksbeard","Alaska Hollyfern","Nemoca","Zion Milkvetch","Hairy Laurel","Homalotheciella Moss","Rim Lichen","Pitseed Goosefoot","Tropical Cupgrass","Harpullia","Goodding's Bladderpod","Running Clubmoss","Round Sedge","Jacob's-ladder","Shortspike Canarygrass","Shield Lichen","Azure Blue Sage","Trachycystis Moss","Sweetwood","Allophylus","Blytt's Bryum Moss","Little Parish's Needlegrass","Palo De Hoz","Parry's Rabbitbrush","Pinpoint Clover","American Saw-wort","Threeleaf Goldthread","Compact Cryptantha","Treetrunk Cyanea","Inuit Wallflower","California Poppy","Marble Canyon Spurge","Prairie Bluebells","Mojave Sandwort","Lesser Fringed Gentian","Deepwoods Horsebalm","Starveling Milkvetch","Sweet Woodreed","Drummond's Goldenbush","Mistassini Primrose","Melanorrhoea","Rabbitbells","Garrett's Florida Pineland Spurge","Utah Bladderfern","California Spikenard","Yellow Bugle","Wrinkleleaf Goldenrod","Bullsuckers","Navajo Fleabane","Rhodesian Copalwood","Serrate Dung Moss","Rambling Dewberry","Western Sweetshrub","Gummy Lovegrass","Alpine Bearberry","Crabseye Lichen","Thoroughwort","Melanelia Lichen","Kauai Cyanea","Idaho Blue-eyed Grass","White Cudweed","Ice Cold Buttercup","American Hornbeam","Fringed Rockdaisy","Striped Gentian","Parish's Popcornflower","Attenuate Indian Paintbrush","Lesser Fringed Gentian","Texas Bruchia Moss","Texas Rush","Jalap","Mexican Alvaradoa","Needle Lichen","Tyrol Knapweed","Sonoran Maiden Fern","Forked Nightshade","Schefflera","Cream Ticktrefoil","Treetrunk Fern","Twistedstalk","Parry's Rabbitbrush","Wooton's Pricklypear","Tharp's Dropseed","Blackthread Lichen","Johnny-jump-up","Mannagrass","Vervain","Roundhead Chinese Houses","Butte County Checkerbloom","British Soldier Lichen","Spiral Dog's-tongue","Blue Huckleberry","Neslia","Seasice Rush","Java-bean","Little Hogweed","Pale Touch-me-not","Lesser Purple Fringed Orchid","Lewisia","Rim Lichen","Desert Lily","Sugarcane","Shrubby Brickellbush","Monument Valley Milkvetch","James' Sedge","Creeping Charlie","Tarovine","Bride's Feathers","Wright's Golden Saxifrage","Reznicek's Sedge","Morocco Iris","Viper Beggarticks","Silky Camellia","Hybrid Oak","Twoflower Pea","Perfumed Spiderlily","Creeping Bentgrass","Cutleaf Cyclanthera","Grants Pass Willowherb","Guadalupe Island Lupine","Browntop Millet","Coccotrema Lichen","Limestone Swamp Bedstraw","Apache Dwarf Mistletoe","Ribbed False Pennyroyal","Arizona Rubberweed","Anoectochilus","Royal Gorge Blazingstar","Cuban Wart Lichen","Spotted Water Hemlock","Recurved Bryoerythrophyllum Moss","Saucerflower","Intermediate Orange Lichen","Tall Buckwheat","Hairy Bird's-beak","Lindheimer's Beebalm","Microstachys","Hawkweed","White Ramoon","Stenocybe Lichen","Meadow Starwort","Pacific Hound's Tongue","Eastern Prickly Gooseberry","Puerto Rico Bully","Bromelia","Longpod Stitchwort","Haggarbush","Brewer's Snapdragon","Maricao Cimun","Rock Phacelia","Lempholemma Lichen","Curlyhead Goldenweed","Polyalthia","Hall's Shrubby-spurge","Racemed Dewberry","Sweet Four O'clock","Sphinctospermum","Savannah-panicgrass","Devil's Gut","Twocrested Milkvetch","Jointfir","Pacific Foxtail","Brittlebush","Carbonea Lichen","Lyall's Goldenweed"};
//	
//	private String nombreNuevoPlaneta;
	
	private int width;
	
	private int height;
	
    public GUI_Crear_Planeta() {
    	
    	
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setUndecorated(false);
        this.setTitle("CREANDO TU PLANETA");
        Toolkit pantalla=Toolkit.getDefaultToolkit();
        Dimension d=pantalla.getScreenSize();
        width=d.width;
        height=d.height;
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("universoProyecto2.gif")));
        setBackground(new java.awt.Color(40, 1, 41));

        
        //creacion boton
		int centerX = width/2;
		int centerY = height/2;
        
        JButton jButton = new JButton("Se ha creado tu planeta :] -> ");
        jButton.setBounds(centerX-45, centerY+50, 210, 80);
        
        this.add(jButton);
        
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            	GUI_Crear_Planeta.super.dispose();
            	//-> PONER NUEVO PANEL: GUI_Crear_Planeta a = new GUI_Crear_Planeta(new String[] {planetaSeleccionado}) ;
            }
        });
        
        this.setVisible(true);
    }
    
}
