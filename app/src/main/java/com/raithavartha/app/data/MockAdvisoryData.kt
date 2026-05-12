package com.raithavartha.app.data

import com.raithavartha.app.model.Advisory

object MockAdvisoryData {
    val cropFilters = listOf("All", "Paddy", "Tomato", "Coconut", "Areca Nut", "Maize", "Ragi")

    val advisories = listOf(
        Advisory(
            id = 1,
            cropEnglish = "Paddy",
            cropKannada = "ಅಕ್ಕಿ",
            category = "Water and Pest",
            titleEnglish = "Maintain shallow water in young paddy",
            titleKannada = "ಯುವ ಅಕ್ಕಿ ಬೆಳೆಯಲ್ಲಿ ಕಡಿಮೆ ನೀರು ಇರಿಸಿ",
            tipEnglish = "Keep 2-3 cm standing water after transplanting and drain excess water after heavy rain.",
            tipKannada = "ನಾಟಿ ನಂತರ 2-3 ಸೆಂ.ಮೀ ನೀರು ಇರಿಸಿ, ಹೆಚ್ಚು ಮಳೆ ಬಂದರೆ ಹೆಚ್ಚುವರಿ ನೀರನ್ನು ಹೊರಹಾಕಿ.",
            diseaseKeywords = listOf("blast", "stem borer", "water", "irrigation"),
            imageUrl = "https://images.unsplash.com/photo-1592997571659-0b21ff64313b?auto=format&fit=crop&w=900&q=80",
            dosage = "Use need-based nitrogen split dose; avoid urea before heavy rain.",
            weather = "Cloudy weather may increase pest pressure.",
            source = "Inspired by ICAR and Karnataka agromet advisory formats"
        ),
        Advisory(
            id = 2,
            cropEnglish = "Paddy",
            cropKannada = "ಅಕ್ಕಿ",
            category = "Harvesting",
            titleEnglish = "Harvest mature paddy and dry grain safely",
            titleKannada = "ಪಕ್ವವಾದ ಅಕ್ಕಿಯನ್ನು ಕೊಯ್ದು ಧಾನ್ಯ ಒಣಗಿಸಿ",
            tipEnglish = "Harvest when most panicles turn golden and dry produce well before storage.",
            tipKannada = "ಹೆಚ್ಚಿನ ತೊಗಲುಗಳು ಬಂಗಾರದ ಬಣ್ಣಕ್ಕೆ ತಿರುಗಿದಾಗ ಕೊಯ್ದು, ಸಂಗ್ರಹಿಸುವ ಮೊದಲು ಚೆನ್ನಾಗಿ ಒಣಗಿಸಿ.",
            diseaseKeywords = listOf("harvest", "grain", "storage", "moisture"),
            imageUrl = "https://images.unsplash.com/photo-1536657464919-892534f60d6e?auto=format&fit=crop&w=900&q=80",
            dosage = "Dry grain to safe moisture before bagging.",
            weather = "Avoid harvesting during rain spells.",
            source = "North Karnataka Agromet Advisory Bulletin, 24 Apr 2026"
        ),
        Advisory(
            id = 3,
            cropEnglish = "Tomato",
            cropKannada = "ಟೊಮೇಟೊ",
            category = "Disease and Pest",
            titleEnglish = "Watch tomato fruit borer and early blight",
            titleKannada = "ಟೊಮೇಟೊ ಹಣ್ಣು ಕೊರೆಕ ಮತ್ತು ಅರ್ಲಿ ಬ್ಲೈಟ್ ಗಮನಿಸಿ",
            tipEnglish = "Remove infected leaves, keep irrigation uniform and use pheromone traps for fruit borer monitoring.",
            tipKannada = "ರೋಗಿತ ಎಲೆಗಳನ್ನು ತೆಗೆದುಹಾಕಿ, ನೀರಾವರಿ ಸಮವಾಗಿ ನೀಡಿ ಮತ್ತು ಹಣ್ಣು ಕೊರೆಕ ವೀಕ್ಷಣೆಗೆ ಫೆರೊಮೋನ್ ಬಲೆ ಬಳಸಿ.",
            diseaseKeywords = listOf("fruit borer", "early blight", "leaf spot", "tomato"),
            imageUrl = "https://images.unsplash.com/photo-1561136594-7f68413baa99?auto=format&fit=crop&w=900&q=80",
            dosage = "Use locally recommended fungicide only after field inspection.",
            weather = "Humid evenings increase leaf disease risk.",
            source = "Inspired by ICAR horticulture advisory formats"
        ),
        Advisory(
            id = 4,
            cropEnglish = "Coconut",
            cropKannada = "ತೆಂಗು",
            category = "Drainage and Pest",
            titleEnglish = "Keep coconut basins drained and mulched",
            titleKannada = "ತೆಂಗಿನ ಬುಡದಲ್ಲಿ ನೀರು ನಿಲ್ಲದಂತೆ ಮಲ್ಚಿಂಗ್ ಮಾಡಿ",
            tipEnglish = "During nut development, maintain the basin, avoid water stagnation and use mulch to conserve soil moisture.",
            tipKannada = "ಕಾಯಿ ಬೆಳವಣಿಗೆ ಸಮಯದಲ್ಲಿ ಬುಡ ಸ್ವಚ್ಛವಾಗಿ ಇಟ್ಟು, ನೀರು ನಿಲ್ಲದಂತೆ ನೋಡಿ ಮತ್ತು ಮಣ್ಣಿನ ತೇವ ಉಳಿಸಲು ಮಲ್ಚಿಂಗ್ ಮಾಡಿ.",
            diseaseKeywords = listOf("coconut", "root wilt", "rhinoceros beetle", "drainage"),
            imageUrl = "https://images.unsplash.com/photo-1580984969071-a8da5656c2fb?auto=format&fit=crop&w=900&q=80",
            dosage = "Neem cake in basin; Bordeaux mixture in crown as locally advised.",
            weather = "Humid weather may increase crown disease risk.",
            source = "Inspired by IMD Bengaluru agromet advisory style"
        ),
        Advisory(
            id = 5,
            cropEnglish = "Areca Nut",
            cropKannada = "ಅಡಿಕೆ",
            category = "Disease Management",
            titleEnglish = "Prevent koleroga with drainage and sanitation",
            titleKannada = "ನೀರು ಹರಿವು ಮತ್ತು ಸ್ವಚ್ಛತೆಯಿಂದ ಕೊಳೆರೋಗ ತಡೆಗಟ್ಟಿ",
            tipEnglish = "Remove fallen infected nuts and improve drainage around palms during continuous rain.",
            tipKannada = "ನಿರಂತರ ಮಳೆಯ ಸಮಯದಲ್ಲಿ ಬಿದ್ದ ರೋಗಿತ ಕಾಯಿಗಳನ್ನು ತೆಗೆದುಹಾಕಿ ಮತ್ತು ತೋಟದಲ್ಲಿ ನೀರು ಹರಿಯುವಂತೆ ಮಾಡಿ.",
            diseaseKeywords = listOf("koleroga", "fruit rot", "arecanut", "fungus"),
            imageUrl = "https://images.unsplash.com/photo-1622206151226-18ca2c9ab4a1?auto=format&fit=crop&w=900&q=80",
            dosage = "Follow local officer advice for Bordeaux spray schedule.",
            weather = "Continuous rain favors fruit rot.",
            source = "Inspired by Karnataka plantation crop advisories"
        ),
        Advisory(
            id = 6,
            cropEnglish = "Maize",
            cropKannada = "ಜೋಳ",
            category = "Nutrient and Pest",
            titleEnglish = "Scout maize for fall armyworm",
            titleKannada = "ಜೋಳದಲ್ಲಿ ಫಾಲ್ ಆರ್ಮಿವರ್ಮ್ ವೀಕ್ಷಿಸಿ",
            tipEnglish = "Inspect whorls weekly, give support during gusty winds and finish field operations during morning hours.",
            tipKannada = "ವಾರಕ್ಕೊಮ್ಮೆ ಸಸ್ಯದ ಮಧ್ಯ ಭಾಗ ಪರಿಶೀಲಿಸಿ, ಗಾಳಿ ಸಮಯದಲ್ಲಿ ಬೆಂಬಲ ನೀಡಿ ಮತ್ತು ಹೊಲದ ಕೆಲಸಗಳನ್ನು ಬೆಳಿಗ್ಗೆ ಮಾಡಿ.",
            diseaseKeywords = listOf("fall armyworm", "maize", "whorl", "irrigation"),
            imageUrl = "https://images.unsplash.com/photo-1551754655-cd27e38d2076?auto=format&fit=crop&w=900&q=80",
            dosage = "Use recommended bio-control or insecticide only at economic threshold.",
            weather = "Thunderstorm and gusty wind risk.",
            source = "North Karnataka Agromet Advisory Bulletin, 24 Apr 2026"
        ),
        Advisory(
            id = 7,
            cropEnglish = "Ragi",
            cropKannada = "ರಾಗಿ",
            category = "Moisture Conservation",
            titleEnglish = "Conserve moisture in ragi fields",
            titleKannada = "ರಾಗಿ ಹೊಲದಲ್ಲಿ ತೇವಾಂಶ ಸಂರಕ್ಷಿಸಿ",
            tipEnglish = "Keep fields weed-free, use intercultivation in morning hours and mulch crop residues to conserve moisture.",
            tipKannada = "ಹೊಲವನ್ನು ಕಳೆರಹಿತವಾಗಿಡಿ, ಬೆಳಿಗ್ಗೆ ಅಂತರ ಬೆಳೆಗಾರಿಕೆ ಮಾಡಿ ಮತ್ತು ತೇವ ಉಳಿಸಲು ಬೆಳೆ ಅವಶೇಷಗಳಿಂದ ಮಲ್ಚಿಂಗ್ ಮಾಡಿ.",
            diseaseKeywords = listOf("ragi", "blast", "moisture", "weeds"),
            imageUrl = "https://images.unsplash.com/photo-1605000797499-95a51c5269ae?auto=format&fit=crop&w=900&q=80",
            dosage = "Top dress nitrogen only when adequate soil moisture is available.",
            weather = "Light rain supports intercultivation.",
            source = "North Karnataka Agromet Advisory Bulletin, 24 Apr 2026"
        )
    )
}
