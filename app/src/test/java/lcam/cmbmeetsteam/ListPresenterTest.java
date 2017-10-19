package lcam.cmbmeetsteam;

import com.leoncam.cmbmeetsteam.model.TeamMember;
import com.leoncam.cmbmeetsteam.service.ListServices;
import com.leoncam.cmbmeetsteam.view.MainListView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;

/**
 * Local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ListPresenterTest {
    private static List<TeamMember> teamMemberList = new ArrayList<>();

    private com.leoncam.cmbmeetsteam.presenter.ListPresenter listPresenter;

    @Mock
    private MainListView mainListView;

    @Mock
    private ListServices listServices;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        listPresenter = new com.leoncam.cmbmeetsteam.presenter.ListPresenter(mainListView, listServices);
    }

    @Test
    public void loadJSONData() {
        // Loading of data is requested
        listPresenter.loadData();

        // Verify json Data gets loaded
        verify(listServices).loadData();

        // Attempt to pass the data back to the view
        listPresenter.updateView(teamMemberList);

        // Verify view attempts to update
        verify(mainListView).updateList(teamMemberList);
    }
}