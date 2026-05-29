package com.waseefakhtar.carebuddy.navigation

import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.waseefakhtar.carebuddy.feature.addmedication.navigation.addMedicationGraph
import com.waseefakhtar.carebuddy.feature.calendar.navigation.calendarGraph
import com.waseefakhtar.carebuddy.feature.history.historyGraph
import com.waseefakhtar.carebuddy.feature.home.navigation.HomeDestination
import com.waseefakhtar.carebuddy.feature.home.navigation.homeGraph
import com.waseefakhtar.carebuddy.feature.medicationconfirm.navigation.MEDICATION
import com.waseefakhtar.carebuddy.feature.medicationconfirm.navigation.MedicationConfirmDestination
import com.waseefakhtar.carebuddy.feature.medicationconfirm.navigation.medicationConfirmGraph
import com.waseefakhtar.carebuddy.feature.medicationdetail.MedicationDetailDestination
import com.waseefakhtar.carebuddy.feature.medicationdetail.medicationDetailGraph
import com.waseefakhtar.carebuddy.util.navigateSingleTop

@Composable
fun CareBuddyNavHost(
    bottomBarVisibility: MutableState<Boolean>,
    fabVisibility: MutableState<Boolean>,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = HomeDestination.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        homeGraph(
            navController = navController,
            bottomBarVisibility = bottomBarVisibility,
            fabVisibility = fabVisibility,
            navigateToMedicationDetail = { medication ->
                navController.navigate(
                    MedicationDetailDestination.createNavigationRoute(medication.id)
                )
            }
        )
        historyGraph(
            bottomBarVisibility = bottomBarVisibility,
            fabVisibility = fabVisibility,
            navigateToMedicationDetail = { medication ->
                navController.navigate(
                    MedicationDetailDestination.createNavigationRoute(medication.id)
                )
            }
        )
        medicationDetailGraph(
            bottomBarVisibility = bottomBarVisibility,
            fabVisibility = fabVisibility,
            onBackClicked = { navController.navigateUp() }
        )
        calendarGraph(bottomBarVisibility, fabVisibility)
        addMedicationGraph(
            navController = navController,
            bottomBarVisibility = bottomBarVisibility,
            fabVisibility = fabVisibility,
            onBackClicked = { navController.navigateUp() },
            navigateToMedicationConfirm = {
                val bundle = Bundle()
                bundle.putParcelableArrayList(MEDICATION, ArrayList(it))
                navController.currentBackStackEntry?.savedStateHandle.apply {
                    this?.set(MEDICATION, bundle)
                }
                navController.navigate(MedicationConfirmDestination.route)
            }
        )
        medicationConfirmGraph(
            navController = navController,
            bottomBarVisibility = bottomBarVisibility,
            fabVisibility = fabVisibility,
            onBackClicked = { navController.navigateUp() },
            navigateToHome = {
                navController.navigateSingleTop(HomeDestination.route)
            }
        )
    }
}
