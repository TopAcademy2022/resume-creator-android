package resume.creator.android;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {

    private List<CardItem> cardItemList;

    public CardAdapter(List<CardItem> cardItemList) {
        this.cardItemList = cardItemList;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        CardItem cardItem = cardItemList.get(position);
        holder.cardText.setText(cardItem.getTitle());
        holder.conteyner.setBackground(cardItem.getImageVelue());

        // Обработчики нажатий для кнопок
        holder.buttonEdit.setOnClickListener(v -> {
            // Логика редактирования
        });

        holder.buttonDelete.setOnClickListener(v -> {
            // Логика удаления
        });

        holder.buttonDownload.setOnClickListener(v -> {
            // Логика скачивания
        });
    }

    @Override
    public int getItemCount() {
        return cardItemList.size();
    }

    static class CardViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout conteyner;
        TextView cardText;
        ImageButton buttonEdit, buttonDelete, buttonDownload;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            conteyner = itemView.findViewById(R.id.conteyner);
            cardText = itemView.findViewById(R.id.card_text);
            buttonEdit = itemView.findViewById(R.id.button_edit);
            buttonDelete = itemView.findViewById(R.id.button_delete);
            buttonDownload = itemView.findViewById(R.id.button_download);
        }
    }
}
