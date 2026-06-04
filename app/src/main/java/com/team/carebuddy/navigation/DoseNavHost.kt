package com.team.carebuddy.navigation

import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.team.carebuddy.feature.addmedication.navigation.addMedicationGraph
import com.team.carebuddy.feature.calendar.navigation.calendarGraph
import com.team.carebuddy.feature.history.historyGraph
import com.team.carebuddy.feature.home.navigation.HomeDestination
import com.team.carebuddy.feature.home.navigation.homeGraph
import com.team.carebuddy.feature.medicationconfirm.navigation.MEDICATION
import com.team.carebuddy.feature.medicationconfirm.navigation.MedicationConfirmDestination
import com.team.carebuddy.feature.medicationconfirm.navigation.medicationConfirmGraph
import com.team.carebuddy.feature.medicationdetail.MedicationDetailDestination
import com.team.carebuddy.feature.medicationdetail.medicationDetailGraph
import com.team.carebuddy.util.navigateSingleTop

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
                // TODO: Replace with medication id
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
