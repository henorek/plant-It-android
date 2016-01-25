package net.henorek.plantit.ui.widgets.adapters;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.hannesdorfmann.annotatedadapter.annotation.ViewField;
import com.hannesdorfmann.annotatedadapter.annotation.ViewType;
import com.hannesdorfmann.annotatedadapter.support.recyclerview.SupportAnnotatedAdapter;
import com.squareup.picasso.Picasso;

import net.henorek.plantit.R;
import net.henorek.plantit.data.models.GameLevel;

import java.util.List;

import javax.inject.Inject;

import lombok.Getter;
import lombok.Setter;

public class GameLevelsAdapter extends SupportAnnotatedAdapter implements GameLevelsAdapterBinder {

    @ViewType(
            layout = R.layout.game_level_element,
            views = {
                    @ViewField(id = R.id.icon, type = ImageView.class, name = "icon"),
                    @ViewField(id = R.id.background, type = ImageView.class, name = "background"),
                    @ViewField(id = R.id.name, type = TextView.class, name = "name")
            })

    public final int gameLevel = 0;

    @Getter
    @Setter
    List<GameLevel> gameLevels;

    Picasso picasso;

    @Inject
    public GameLevelsAdapter(Context context, Picasso picasso) {
        super(context);
        this.picasso = picasso;
    }

    @Override
    public int getItemCount() {
        return gameLevels == null ? 0 : gameLevels.size();
    }

    @Override
    public void bindViewHolder(GameLevelsAdapterHolders.GameLevelViewHolder vh, int position) {
        GameLevel gameLevel = gameLevels.get(position);

        vh.name.setText(gameLevel.getName());

        picasso.load(gameLevel.getIconUrl())
                .placeholder(R.color.plantit_dark_gray)
                .error(R.color.plantit_black)
                .into(vh.icon);

        picasso.load(gameLevel.getBackgroundUrl())
                .placeholder(R.color.plantit_dark_gray)
                .error(R.color.plantit_black)
                .into(vh.background);
    }
}